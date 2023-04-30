package com.nailorsh.fuels.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nailorsh.fuels.R
import kotlinx.coroutines.delay

@Composable
fun StartSplashScreen(
    onNextButtonClicked: () -> Unit = {},
//    modifier: Modifier = Modifier
) {
    val image = painterResource(R.drawable.nv_command)

    LaunchedEffect(key1 = true) {
        delay(1500)
        onNextButtonClicked()
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = image,
            contentDescription = "NV",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(top = 25.dp)
                .size(200.dp)
                .clip(CircleShape)
        )
    }

}

@Preview(
    name = "Preview",
    showSystemUi = false,
    showBackground = true
)
@Composable
fun SplashScreenPreview() = StartSplashScreen()