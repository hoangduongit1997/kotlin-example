package com.example.woof

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.woof.data.Dog
import com.example.woof.data.dogs
import com.example.woof.ui.theme.WoofTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WoofTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { WoofTopAppBar() }
                ) {
                    LazyColumn(
                        contentPadding = it,
                        verticalArrangement = Arrangement.spacedBy(16.dp),


                    ) {
                        items(dogs) { item ->
                            DogItem(dog = item)
                        }
                    }


                }
            }
        }
    }

    @Composable
    fun DogItem(
        dog: Dog,
        modifier: Modifier = Modifier
    ) {
        Card(
            modifier = modifier.padding(horizontal = 16.dp),

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small))
            ) {
                DogIcon(dog.imageResourceId)
                DogInformation(dog.name, dog.age)
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun WoofTopAppBar(modifier: Modifier = Modifier) {
        CenterAlignedTopAppBar(
            title = {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier
                            .size(dimensionResource(R.dimen.image_size))
                            .padding(dimensionResource(R.dimen.padding_small)),
                        painter = painterResource(R.drawable.ic_launcher_foreground),

                        // Content Description is not needed here - image is decorative, and setting a
                        // null content description allows accessibility services to skip this element
                        // during navigation.

                        contentDescription = null
                    )
                    Text(
                        text = stringResource(R.string.app_name),
                        style = MaterialTheme.typography.displayLarge
                    )
                }
            },
            modifier = modifier
        )
    }

    @Composable
    fun DogIcon(
        @DrawableRes dogIcon: Int,
        modifier: Modifier = Modifier
    ) {
        Image(
            modifier = modifier
                .size(dimensionResource(R.dimen.image_size))
                .padding(dimensionResource(R.dimen.padding_small))
                .clip(MaterialTheme.shapes.small),
            contentScale = ContentScale.Crop,
            painter = painterResource(dogIcon),

            // Content Description is not needed here - image is decorative, and setting a null content
            // description allows accessibility services to skip this element during navigation.

            contentDescription = null
        )
    }

    @Composable
    fun DogInformation(
        @StringRes dogName: Int,
        dogAge: Int,
        modifier: Modifier = Modifier
    ) {
        Column(modifier = modifier) {
            Text(
                text = stringResource(dogName),
                style = MaterialTheme.typography.displayMedium,
                modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
            )
            Text(
                text = stringResource(R.string.years_old, dogAge),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }

}

