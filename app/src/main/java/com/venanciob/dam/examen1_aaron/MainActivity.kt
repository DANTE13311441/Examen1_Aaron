package com.venanciob.dam.examen1_aaron

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.venanciob.dam.examen1_aaron.ui.theme.Examen1_AaronTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Examen1_AaronTheme {
                Surface(

                ) {
                    PantallaBiblioteca()
                }
            }
        }
    }
}

data class Libro(
    val titulo: String,
    val autor: String,
    val descripcion: String,
)

val Libros = listOf(
    Libro(
        "El señor de los anillos",
        "J.R.R. Tolkien",
        "Una novela épica de fantasía. Estupido Flanders Estupido Flanders Estupido Flanders Estupido Flanders Estupido Flanders Estupido Flanders Estupido Flanders \n Segunda linea no se que"
    ),
    Libro(
        "1984",
        "George Orwell",
        "Una novela distópica de ciencia ficción, escrita por George Orwell. Estupido Flanders Estupido Flanders Estupido Flanders Estupido Flanders Estupido Flanders \n Segunda linea no se que"
    ),
    Libro(
        "Cien años de soledad",
        "Gabriel García Márquez",
        "Una novela de amor y decadencia. Estupido Flanders Estupido Flanders Estupido Flanders Estupido Flanders Estupido Flanders \n Segunda linea no se que"
    ),
    Libro(
        "Harry Potter y la piedra filosofal",
        "J.K. Rowling",
        "Una aventura en el mundo mágico. Estupido Flanders Estupido Flanders Estupido Flanders Estupido Flanders \n Segunda linea no se que"
    )
)

@Composable
fun PantallaBiblioteca() {
    val listState = rememberLazyListState()
    var contador by remember { mutableStateOf(0) }
    Column() {
        Surface(
            modifier = Modifier
                .padding(25.dp)
                .fillMaxWidth(),
            shadowElevation = 10.dp,
            tonalElevation = 10.dp,
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Book,
                    contentDescription = "Icono de un libro"
                )
                Column() {
                    Text(text = "MI BIBLIOTECA")
                    Text(text = "Coleccion de Aaron")
                }
                Image(
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(5.dp)
                        .size(50.dp)
                        .clip(CircleShape),
                    painter = painterResource(R.drawable.images),
                    contentDescription = "Libros"
                )

            }

        }
        Surface(
            modifier = Modifier
                .fillMaxWidth(),
            shadowElevation = 10.dp,
            tonalElevation = 10.dp,
        ) {
            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                Text("Pulsaciones= $contador", )
                Spacer(modifier = Modifier.padding(2.dp))
                Button(onClick = { contador++ }){
                    Text("SUMAR 1")
                }
                Spacer(modifier = Modifier.padding(2.dp))
                Button(onClick = { contador=0 }){
                    Text("REINICIAR")
                }
            }
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            LazyColumn(
                state = listState
            ) {
                items(Libros) { libro ->
                    TarjetaLibro(
                        autor = libro.autor,
                        titulo = libro.titulo,
                        descripcion = libro.descripcion
                    )
                }
            }
        }


    }

}

@Composable
fun TarjetaLibro(autor: String, titulo: String, descripcion: String) {

    var expandido by remember { mutableStateOf(false) }
    var expandido2 by remember { mutableStateOf(false) }

    val color by animateColorAsState(
        targetValue = if (expandido)
            MaterialTheme.colorScheme.primaryContainer
        else
            MaterialTheme.colorScheme.surface,
        label = "color"
    )
    val color2 by animateColorAsState(
        targetValue = if (expandido2)
            Color(0xFF64B5F6)
        else
            Color.Gray,
        label = "color"
    )

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .animateContentSize(),
        shape = MaterialTheme.shapes.medium,
        tonalElevation = 5.dp,
        shadowElevation = 5.dp

    ) {
        Column(
            modifier = Modifier
                .padding(5.dp)

        ) {
            Row() {
                Text(
                    text = titulo,
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.titleSmall
                )
                Spacer(modifier = Modifier.weight(1f))
                Surface(
                    modifier = Modifier
                        .padding(10.dp)
                        .animateContentSize()
                        .width(150.dp)
                        .height(30.dp),
                    shape = MaterialTheme.shapes.small,
                    tonalElevation = 5.dp,
                    shadowElevation = 5.dp,
                    color = color2
                ) {
                    Row(
                        modifier = Modifier
                            .clickable {
                                expandido2 = !expandido2
                            }) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Favorito"
                        )
                        Text(text = "Destacado")
                    }
                }
            }

            Spacer(modifier = Modifier.padding(2.dp))
            Text(
                text = autor,
                style = MaterialTheme.typography.labelMedium
            )
            Spacer(modifier = Modifier.padding(2.dp))
            Surface(
                modifier = Modifier

                    .fillMaxWidth()
                    .padding(10.dp)
                    .animateContentSize()
                    .clickable {
                        expandido = !expandido
                    },
                shape = MaterialTheme.shapes.medium,
                tonalElevation = 5.dp,
                shadowElevation = 5.dp,
                color = color
            ) {
                Text(
                    text = descripcion,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = if (expandido) Int.MAX_VALUE else 1
                )
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Examen1_AaronTheme {
        PantallaBiblioteca()
    }
}