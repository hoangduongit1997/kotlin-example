package com.example.affirmations

import android.content.ContentValues.TAG
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.affirmations.data.Datasource
import com.example.affirmations.model.Affirmation
import com.example.affirmations.ui.theme.AffirmationsTheme
import com.google.firebase.Firebase
import com.google.firebase.messaging.messaging

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logFirebaseToken(this)
        enableEdgeToEdge()
        setContent {
            AffirmationsTheme {
                AffirmationApp()
            }
        }
    }

}

fun logFirebaseToken(context: Context){
    Firebase.messaging.getToken().addOnCompleteListener { task ->
        if (!task.isSuccessful) {
            Log.w(TAG, "Fetching FCM registration token failed", task.exception)
            return@addOnCompleteListener
        }

        // Get new FCM registration token
        val token = task.result

        // Log and toast
        val msg = "FCM Registration token: $token"
        Log.d(TAG, msg)
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
}

@Composable
fun AffirmationApp() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .windowInsetsPadding(WindowInsets.safeDrawing)
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.background)


    ) {
        AffirmationList(
            affirmationList = Datasource().loadAffirmations(),
        )
    }
}

@Composable
fun AffirmationList(affirmationList: List<Affirmation>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(affirmationList) { item ->
            AffirmationCard(
                affirmation = item,
            )

        }

    }
}


@Composable
fun AffirmationCard(affirmation: Affirmation, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column {
            Image(
                painter = painterResource(affirmation.imageResourceId),
                contentDescription = stringResource(affirmation.stringResourceId),
                modifier = Modifier.fillMaxWidth().aspectRatio(16f/9f),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(affirmation.stringResourceId),
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(16.dp)
            )

        }
    }
}
