package com.example.androiddevchallenge.stubdata

import androidx.annotation.DrawableRes
import com.example.androiddevchallenge.R
import java.io.Serializable


data class ImageAndDescription(
    val name: String = "",
    @DrawableRes
    val image: Int = 0
): Serializable

data class PuppyInfo(
    val name: String,
    @DrawableRes
    val imageResourceId: Int,
    val breed: String = "",
    val physical: List<ImageAndDescription> = emptyList(),
    val health: List<ImageAndDescription> =  emptyList(),
    val behavioral: List<ImageAndDescription> =  emptyList(),
    var favorite: Boolean = false
):Serializable

object PuppyAdoptionRepository {
    fun getPuppies() = listOf(
        PuppyInfo(
            imageResourceId = R.drawable.ic_husky,
            name = "Max",
            breed = "Siberian Husky",
            physical = listOf(
                ImageAndDescription(name ="Medium (26-60 lbs)", image = R.drawable.ic_height),
                ImageAndDescription("Male", R.drawable.ic_male),
                ImageAndDescription("Young (1-3 years)",R.drawable.ic_weight)
            ),
            health = listOf(ImageAndDescription("Spayed/neutered", R.drawable.ic_healing),
                ImageAndDescription("Vaccinations up-to-date", R.drawable.ic_vaccinations)),
            behavioral = listOf(ImageAndDescription("Good with other dogs",R.drawable.ic_dog)),
            favorite = true
        ),
        PuppyInfo(
            imageResourceId = R.drawable.ic_golden_retriever,
            name = "Charlie",
            breed = "Golden Retriever",
            physical = listOf(
                ImageAndDescription(name ="Large (61-100 lbs)", image = R.drawable.ic_height),
                ImageAndDescription("Female", R.drawable.ic_female),
                ImageAndDescription("Adult (3-8 years)",R.drawable.ic_weight)),
            health = listOf(ImageAndDescription("Spayed/neutered", R.drawable.ic_healing),
                ImageAndDescription("Vaccinations up-to-date", R.drawable.ic_vaccinations)),
            behavioral = listOf(
                ImageAndDescription("House-trained", R.drawable.ic_home),
                ImageAndDescription("Good with other dogs",R.drawable.ic_dog))
        ),
        PuppyInfo(
            imageResourceId = R.drawable.ic_poodles,
            name = "Cooper",
            breed = "Poodles",
            physical = listOf(
                ImageAndDescription(name ="Medium (26-60 lbs)", image = R.drawable.ic_height),
                ImageAndDescription("Female", R.drawable.ic_female),
                ImageAndDescription("Young (1-3 years)",R.drawable.ic_weight)),
            health = listOf(ImageAndDescription("Spayed/neutered", R.drawable.ic_healing),
                ImageAndDescription("Vaccinations up-to-date", R.drawable.ic_vaccinations)),
            behavioral = listOf(
                ImageAndDescription("House-trained", R.drawable.ic_home))
        ),
        PuppyInfo(
            imageResourceId = R.drawable.ic_labrador,
            name = "Buddy",
            breed = "Labrador",
            physical = listOf(
                ImageAndDescription(name ="Medium (26-60 lbs)", image = R.drawable.ic_height),
                ImageAndDescription("Male", R.drawable.ic_male),
                ImageAndDescription("Puppy (less than 1 year)",R.drawable.ic_weight)),
            behavioral = listOf(ImageAndDescription("Good with other dogs",R.drawable.ic_dog)),
            favorite = true
        ),
        PuppyInfo(
            imageResourceId = R.drawable.ic_french_bulldog,
            name = "Jack",
            breed = "French Bulldog",
            physical = listOf(
                ImageAndDescription(name ="Small (0-25 lbs)", image = R.drawable.ic_height),
                ImageAndDescription("Female", R.drawable.ic_female),
                ImageAndDescription("Adult (3-8 years)",R.drawable.ic_weight)),
            health = listOf(ImageAndDescription("Spayed/neutered", R.drawable.ic_healing),
                ImageAndDescription("Vaccinations up-to-date", R.drawable.ic_vaccinations)),
            behavioral = listOf(ImageAndDescription("Good with other dogs",R.drawable.ic_dog))
        ),
        PuppyInfo(
            imageResourceId = R.drawable.ic_terrier,
            name = "Rocky",
            breed = "American Hairless Terrier",
            physical = listOf(
                ImageAndDescription(name ="Large (61-100 lbs)", image = R.drawable.ic_height),
                ImageAndDescription("Male", R.drawable.ic_male),
                ImageAndDescription("Young (1-3 years)",R.drawable.ic_weight)),
            health = listOf(ImageAndDescription("Spayed/neutered", R.drawable.ic_healing),
                ImageAndDescription("Vaccinations up-to-date", R.drawable.ic_vaccinations)),
            behavioral = listOf(
                ImageAndDescription("House-trained", R.drawable.ic_home),
                ImageAndDescription("Good with other dogs",R.drawable.ic_dog)),
            favorite = true
        ),
        PuppyInfo(
            imageResourceId = R.drawable.ic_cane_corso,
            name = "Duke",
            breed = "Cane Corso",
            physical = listOf(
                ImageAndDescription(name ="Medium (26-60 lbs)", image = R.drawable.ic_height),
                ImageAndDescription("Female", R.drawable.ic_female),
                ImageAndDescription("Adult (3-8 years)",R.drawable.ic_weight)),
            health = listOf(ImageAndDescription("Spayed/neutered", R.drawable.ic_healing),
                ImageAndDescription("Vaccinations up-to-date", R.drawable.ic_vaccinations)),
            behavioral = listOf(ImageAndDescription("Good with other dogs",R.drawable.ic_dog)),
            favorite = true
        ),
        PuppyInfo(
            imageResourceId = R.drawable.ic_pomeranian,
            name = "Bear",
            breed = "Pomeranian",
            physical = listOf(
                ImageAndDescription(name ="small (0-25 lbs)", image = R.drawable.ic_height),
                ImageAndDescription("Male", R.drawable.ic_male),
                ImageAndDescription("Senior (8+ years)",R.drawable.ic_weight)),
            health = listOf(ImageAndDescription("Spayed/neutered", R.drawable.ic_healing)),
            behavioral = listOf(
                ImageAndDescription("House-trained", R.drawable.ic_home),
                ImageAndDescription("Good with other dogs",R.drawable.ic_dog)),
            favorite = true
        ) ,
        PuppyInfo(name = "Rubby", imageResourceId = R.drawable.img_rubby,
        breed = "German Shepherd",
        physical = listOf(
            ImageAndDescription(name ="Medium (26-60 lbs)", image = R.drawable.ic_height),
            ImageAndDescription("Male", R.drawable.ic_male),
            ImageAndDescription("Puppy (less than 1 year)",R.drawable.ic_weight)),
        health = listOf(ImageAndDescription("Spayed/neutered", R.drawable.ic_healing)),
        behavioral = listOf(
            ImageAndDescription("House-trained", R.drawable.ic_home),
            ImageAndDescription("Good with other dogs",R.drawable.ic_dog)))
    )
}