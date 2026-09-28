package com.servin.angel.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.servin.angel.compose.ui.theme.MiPokedex_ServinAngelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiPokedex_ServinAngelTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PokemonDetailScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun PokemonDetailScreen(modifier: Modifier = Modifier) {
    val moradoOscuro = colorResource(id = R.color.morado_oscuro)
    val naranja = colorResource(id = R.color.naranja)

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(moradoOscuro)
    ) {

        Image(
            painter = painterResource(id = R.drawable.background_white),
            contentDescription = "Fondo Blanco",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.65f)
                .align(Alignment.BottomCenter)
        )

        Image(
            painter = painterResource(id = R.drawable.bola),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(top = 52.dp, end = 4.dp)
                .size(145.dp, 168.dp)
                .align(Alignment.TopEnd)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, top = 40.dp, end = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = stringResource(id = R.string.pokemon_nombre),
                    color = Color.White,
                    fontSize = 20.sp
                )
                Text(
                    text = stringResource(id = R.string.pokemon_numero),
                    color = Color.White,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 40.dp)
                )
            }
            IconButton(onClick = { /* TODO: Acción estrella */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_estrella),
                    contentDescription = "Favorito",
                    tint = Color.Unspecified
                )
            }
        }

        Image(
            painter = painterResource(id = R.drawable.ceruledge),
            contentDescription = "Ceruledge",
            modifier = Modifier
                .padding(top = 90.dp)
                .size(219.dp, 215.dp)
                .align(Alignment.TopCenter)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.65f)
                .align(Alignment.BottomCenter)
                .padding(top = 90.dp, start = 24.dp, end = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.padding(bottom = 20.dp)
            ) {
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = naranja)
                ) {
                    Text(text = stringResource(id = R.string.tipo_fuego), color = Color.White)
                }
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = moradoOscuro)
                ) {
                    Text(text = stringResource(id = R.string.tipo_fantasma), color = Color.White)
                }
            }

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                StatRow(
                    label = stringResource(id = R.string.altura),
                    value = stringResource(id = R.string.pokemon_altura),
                    labelColor = moradoOscuro
                )
                StatRow(
                    label = stringResource(id = R.string.peso),
                    value = stringResource(id = R.string.pokemon_peso),
                    labelColor = moradoOscuro
                )
                StatRow(
                    label = stringResource(id = R.string.habilidad),
                    value = stringResource(id = R.string.pokemon_habilidad_valor),
                    labelColor = moradoOscuro
                )
            }

            Text(
                text = stringResource(id = R.string.pokemon_descripcion),
                color = Color.Black,
                fontSize = 18.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {

                EvolutionItem(
                    imageRes = R.drawable.charcadet,
                    text = stringResource(id = R.string.evolucion_anterior),
                    iconRes = R.drawable.ic_flecha
                )

                EvolutionItem(
                    imageRes = R.drawable.armarouge,
                    text = stringResource(id = R.string.evolucion_siguiente),
                    iconRes = R.drawable.ic_flecha_derecha
                )
            }
        }
    }
}

@Composable
fun StatRow(label: String, value: String, labelColor: Color) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = label,
            color = labelColor,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(end = 8.dp)
        )
        Text(
            text = value,
            color = Color.Black,
            fontSize = 18.sp
        )
    }
}

@Composable
fun EvolutionItem(imageRes: Int, text: String, iconRes: Int) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = text,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(88.dp, 102.dp)
        )
        Text(
            text = text,
            color = Color.Black,
            modifier = Modifier.padding(vertical = 4.dp)
        )
        IconButton(onClick = { /* TODO */ }) {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                tint = Color.Unspecified
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonScreenPreview() {
    MiPokedex_ServinAngelTheme {
        PokemonDetailScreen()
    }
}