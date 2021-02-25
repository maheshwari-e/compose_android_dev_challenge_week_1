/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.stubdata.PuppyAdoptionRepository
import com.example.androiddevchallenge.stubdata.PuppyInfo
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val clickAction = { puppy: PuppyInfo ->
            startActivity(Intent(this, PuppyDetailsActivity::class.java).apply {
                putExtra("puppy",puppy)
            })
        }
        setContent {
            MyTheme {
                MyApp(clickAction)
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp(action: (PuppyInfo) -> Unit) {
    Surface(color = MaterialTheme.colors.background) {
        ToolBar(action)
    }
}

@Composable
fun ToolBar(action: (PuppyInfo) -> Unit) {
    Column() {
        TopAppBar(
            title = { Text(text = "Puppies Adoption") }, navigationIcon = null)
        ListPuppies(puppy = PuppyAdoptionRepository.getPuppies(), action = action)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ListPuppies(puppy: List<PuppyInfo>, action: (PuppyInfo) -> Unit) {
    LazyVerticalGrid(cells = GridCells.Adaptive(minSize = 128.dp)) {
        items(puppy){ Puppy(it,action) }
    }
}

@Composable
fun Puppy(puppy: PuppyInfo, onClick: (PuppyInfo) -> Unit) {
    Card(shape = MaterialTheme.shapes.small,
        modifier = Modifier.padding(4.dp)
            .clickable(onClick = { onClick(puppy) }),
        elevation = 8.dp
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally){
            Box(modifier = Modifier.fillMaxWidth().height(150.dp)) {
                Image(
                    painter = painterResource(puppy.imageResourceId),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                Box(contentAlignment = Alignment.BottomEnd,
                    modifier = Modifier.fillMaxSize().padding(4.dp)){
                    Image(painter =
                    painterResource(if(puppy.favorite) R.drawable.ic_hearted else R.drawable.ic_heart),
                        contentDescription = null
                    )
                }
            }
            Text(puppy.name, style = (MaterialTheme.typography).body1
                .copy(fontSize = 16.sp)
                .merge(TextStyle(fontWeight = FontWeight.Bold)),
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp({})
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp({})
    }
}
