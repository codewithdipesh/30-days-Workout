package com.example.a30daysworkout

import WorkoutTheme
import android.widget.ImageButton
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30daysworkout.Data.WorkoutData
import com.example.a30daysworkout.Data.WorkoutData.workoutdatalist
import com.example.a30daysworkout.Model.Workout


@Composable
fun WorkoutApp(){
    Scaffold (
        topBar = {
            TopBar()
        },
        modifier = Modifier
    ){it->
        WorkoutList(contentPadding = it)
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(modifier: Modifier=Modifier){
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.displayLarge)
        },
        modifier=modifier)
}


@Composable
fun WorkoutList(
    modifier: Modifier=Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)

){
    LazyColumn(
         modifier=Modifier
             .padding(
                 top = dimensionResource(id = R.dimen.padding_medium),
                start = dimensionResource(id = R.dimen.padding_medium),
                end = dimensionResource(id = R.dimen.padding_medium)
              ),
        contentPadding = contentPadding
      
        ){
        items(workoutdatalist){workout->
            WorkoutCard(workout = workout)
            Spacer(modifier = Modifier.height(16.dp))

        }

    }

}

@Composable
fun WorkoutCard(workout: Workout,modifier: Modifier=Modifier){
    var expanded by remember {
        mutableStateOf(false)
    }
    Card(
        modifier= Modifier
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            )
        {
        Column(
            modifier= Modifier
                .padding(dimensionResource(id = R.dimen.padding_small))
                .clickable {
                    expanded = !expanded
                }
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
        ) {
            //Day
            Row(modifier=modifier) {

                //Title
                Text(
                    text = stringResource(id = workout.TitleRes),
                    style = MaterialTheme.typography.displaySmall,
                    modifier=Modifier
                        .weight(1f)
                )

                Text(
                    text = "Day ${workout.day.toString()}",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier=Modifier
                        .align(Alignment.CenterVertically)


                )

            }

            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
            //Image
            Box (
                modifier= Modifier
                    .height(dimensionResource(id = R.dimen.image_height))
                    .clip(RoundedCornerShape(dimensionResource(id = R.dimen.padding_small)))

            ){
                Image(
                    painter = painterResource(id = workout.ImageRes) ,
                    contentDescription = stringResource(id = workout.DescriptionRes),
                    contentScale = ContentScale.FillWidth,
                    alignment = Alignment.BottomCenter,
                    modifier = modifier
                )
            }
             if(expanded){

                Text(
                    text = stringResource(id = workout.DescriptionRes),
                    style = MaterialTheme.typography.bodySmall,
                    modifier= Modifier
                        .padding(top = dimensionResource(id = R.dimen.padding_small))
                )
            }

            
        }
    }
}






@Preview(showBackground = true)
@Composable
fun AppPreview(){
    WorkoutTheme {
        WorkoutApp()
    }
}


