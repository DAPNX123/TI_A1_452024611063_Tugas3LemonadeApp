package com.example.ti_a1_452024611063_tugas3lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ti_a1_452024611063_tugas3lemonadeapp.ui.theme.TI_A1_452024611063_Tugas3LemonadeAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TI_A1_452024611063_Tugas3LemonadeAppTheme {
                LemonApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonApp() {
    // Menyimpan state/langkah saat ini (1 sampai 4)
    var currentStep by remember { mutableStateOf(1) }
    // Menyimpan jumlah tap yang dibutuhkan untuk memeras lemon
    var squeezeCount by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Lemonade",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = Color(0xFFF9E42E) // Warna kuning sesuai gambar
                )
            )
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            color = MaterialTheme.colorScheme.background
        ) {
            when (currentStep) {
                1 -> {
                    LemonTextAndImage(
                        textLabel = "Tap the lemon tree to select a lemon",
                        drawableResourceId = R.drawable.lemon_tree,
                        contentDescriptionResourceId = "Lemon Tree",
                        onImageClick = {
                            currentStep = 2
                            // Menentukan jumlah tap acak untuk memeras lemon (biasanya 2-4 kali)
                            squeezeCount = (2..4).random()
                        }
                    )
                }
                2 -> {
                    LemonTextAndImage(
                        textLabel = "Keep tapping the lemon to squeeze it",
                        drawableResourceId = R.drawable.lemon_squeeze,
                        contentDescriptionResourceId = "Lemon",
                        onImageClick = {
                            squeezeCount--
                            if (squeezeCount == 0) {
                                currentStep = 3
                            }
                        }
                    )
                }
                3 -> {
                    LemonTextAndImage(
                        textLabel = "Tap the lemonade to drink it",
                        drawableResourceId = R.drawable.lemon_drink,
                        contentDescriptionResourceId = "Glass of lemonade",
                        onImageClick = {
                            currentStep = 4
                        }
                    )
                }
                4 -> {
                    LemonTextAndImage(
                        textLabel = "Tap the empty glass to start again",
                        drawableResourceId = R.drawable.lemon_restart,
                        contentDescriptionResourceId = "Empty glass",
                        onImageClick = {
                            currentStep = 1
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun LemonTextAndImage(
    textLabel: String,
    drawableResourceId: Int,
    contentDescriptionResourceId: String,
    onImageClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(32.dp))
                .background(Color(0xFFC3ECD2)) // Warna hijau mint/terang sesuai gambar
                .clickable { onImageClick() }
                .padding(32.dp)
        ) {
            Image(
                painter = painterResource(drawableResourceId),
                contentDescription = contentDescriptionResourceId,
                modifier = Modifier
                    .width(128.dp)
                    .height(128.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = textLabel,
            fontSize = 18.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TI_A1_452024611063_Tugas3LemonadeAppTheme {
        LemonApp()
    }
}