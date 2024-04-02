package com.example.wly

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wly.ui.theme.WlyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WlyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier= Modifier){
    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }
    Surface(modifier, color = MaterialTheme.colorScheme.background){
        if(shouldShowOnboarding){
            OnboardingScreen(onContinueClicked={shouldShowOnboarding=false})
        }else{
            Greetings()
        }
    }
}
@Composable
fun OnboardingScreen(
    onContinueClicked:()->Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text("欢迎来到训练营")
        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            onClick = onContinueClicked
        ) {
            Text("继续")
        }
    }
}
@Composable
private fun  Greetings(
    modifier: Modifier = Modifier,
    indexs: List<Int> = listOf(0,1),
    names:List<String> = List(2){"$it"},
    textContents: List<String> = listOf(
        stringResource(id =R.string.text1),
        stringResource(id =R.string.text2),
    )
){
    LazyColumn (modifier=modifier.padding(vertical = 4.dp)){
        items(items=indexs){index ->
            Greeting( name= names[index],textContents[index])
        }
    }
}
@Composable
private  fun Greeting(name: String,textContent:String,modifier: Modifier= Modifier){
    Card (
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ){
        CardContent(name,textContent)
    }
}
@Composable
private fun CardContent(name: String,textContent: String) {
    var expanede by rememberSaveable { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .padding(12.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioLowBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
        ) {
            Text(text = "Hello")
            Text(
                text = name, style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.ExtraBold
                )
            )
            if (expanede) {
                Text(
                    text = textContent,

                )
            }
        }
        IconButton(onClick = { expanede = !expanede}) {
            Icon(
                imageVector = if (expanede) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                contentDescription = if (expanede) {
                    stringResource(R.string.哈哈哈)
                } else {
                    stringResource(R.string.哈哈哈)
                }

            )
        }
    }
}
@Preview
@Composable
fun MyAppPreview(){
    WlyTheme {
        MyApp()
    }
}