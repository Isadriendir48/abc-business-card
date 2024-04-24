package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(
                                start = 40.dp,
                                end = 40.dp
                            )
                    )
                }
            }
        }

    }
}

@Composable
fun PersonalInfoCard(photo: Painter, name: String, title: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = photo,
            contentDescription = null,
            contentScale = ContentScale.Inside,
            modifier = Modifier
                .width(220.dp)
        )

        Text(
            text = name,
            modifier = Modifier
                .padding(top = 10.dp),
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = title,
            fontWeight = FontWeight.Light,
            modifier = Modifier
                .padding(top = 8.dp)
        )
    }
}

@Composable
fun SocialNetworkCard(icon: Painter, info: String, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier
    ) {
        Icon(
            painter = icon,
            contentDescription = null,
            modifier = Modifier.padding(end = 8.dp)
        )

        Text(
            text = info
        )
    }
}

@Composable
fun SocialMediaList(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        SocialNetworkCard(
            icon = painterResource(id = R.drawable.stacked_email_24px),
            info = stringResource(R.string.email_address),
            Modifier.fillMaxWidth()
        )

        SocialNetworkCard(
            icon = painterResource(id = R.drawable.smartphone_24px),
            info = stringResource(R.string.phone_number),
            Modifier.fillMaxWidth()
        )

        SocialNetworkCard(
            icon = painterResource(id = R.drawable.public_24px),
            info = stringResource(R.string.social_network_link),
            Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        PersonalInfoCard(
            photo = painterResource(id = R.drawable.img_20231207_174834_hdr),
            name = stringResource(id = R.string.person_name),
            title = stringResource(id = R.string.person_title)
        )

        Spacer(
            modifier = Modifier
                .height(80.dp)
        )

        SocialMediaList(
            modifier = Modifier.height(200.dp)
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 40.dp,
                    end = 40.dp
                )
        )
    }
}