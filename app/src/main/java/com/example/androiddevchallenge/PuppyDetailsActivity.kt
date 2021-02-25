package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.stubdata.ImageAndDescription
import com.example.androiddevchallenge.stubdata.PuppyInfo
import com.example.androiddevchallenge.ui.theme.MyTheme

class PuppyDetailsActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val puppy = intent.getSerializableExtra("puppy") as PuppyInfo
        setContent {
            MyTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Column() {
                        TopAppBar(title = { Text(text = puppy.name) },
                            navigationIcon = {
                                IconButton(onClick = {finish()}) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_arrow_back),
                                        contentDescription = null
                                    )
                                }
                            })
                        ShowPuppyDetails(puppy)
                    }
                }
            }
        }
    }
}

@Composable
fun ShowPuppyDetails(puppy: PuppyInfo) {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
       Box(modifier = Modifier
           .fillMaxWidth()
           .height(250.dp)) {
           Image(painter = painterResource(puppy.imageResourceId), contentDescription = null,
               contentScale = ContentScale.Crop)
             Box(contentAlignment = Alignment.BottomEnd,
                 modifier = Modifier
                     .fillMaxSize()
                     .padding(8.dp)) {
                 Image(painter =
                 painterResource(if(puppy.favorite) R.drawable.ic_hearted else R.drawable.ic_heart),
                     contentDescription = null,
                     modifier = Modifier.clickable(onClick = {})
                 ) }
       }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                puppy.name, modifier = Modifier.padding(16.dp),
                style = (MaterialTheme.typography).body1.copy(fontSize = 24.sp)
                    .merge(TextStyle(fontWeight = FontWeight.Bold))
            )
        }
        Text("BREED", modifier = Modifier.padding(16.dp, 16.dp, 16.dp, 8.dp))
        PuppyDescription(image = R.drawable.ic_pets, desc = puppy.breed)
        PuppyCharacteristics(details = puppy.physical,"PHYSICAL CHARACTERISTICS" )
        PuppyCharacteristics(details = puppy.health, category = "HEALTH")
        PuppyCharacteristics(details = puppy.behavioral, category = "BEHAVIORAL CHARACTERISTICS")
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {},
            modifier = Modifier
                .padding(40.dp, 20.dp)
                .fillMaxWidth()){
                Text("Adopt Me", style = MaterialTheme.typography.button
                    .copy(fontWeight = FontWeight.ExtraBold))
            }
        }
    }
}
@Composable
fun PuppyCharacteristics(details: List<ImageAndDescription>, category: String){
     if(details.isNotEmpty())Text(category, modifier = Modifier.padding(16.dp, 16.dp, 16.dp, 8.dp))
     Column{
        details.forEach {
            PuppyDescription(image = it.image, desc = it.name) }
    }
}
@Composable
fun PuppyDescription(image: Int, desc: String){
    Row {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier.padding(16.dp,8.dp)
        )
        Text(
            desc, modifier = Modifier.padding(0.dp,8.dp),
            style = (MaterialTheme.typography).body1.copy(fontSize = 16.sp)
        )
    }
}

