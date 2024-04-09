package com.example.a30daysworkout

import WorkoutTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30daysworkout.Model.Workout


@Composable
fun WorkoutApp(){
    WorkoutCard(workout = Workout(1,R.drawable.workout,R.string.day1,R.string.day1des))
}

@Composable
fun WorkoutCard(workout: Workout,modifier: Modifier=Modifier){
    Card(modifier=modifier) {
        Column(modifier=modifier) {
            //Day
            Text(
                text = "Day ${workout.day.toString()}"
            )
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_extra_small)))
            //Title
            Text(
                text = stringResource(id = workout.TitleRes)
            )
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
            //Image
            Image(
                painter = painterResource(id = workout.ImageRes) ,
                contentDescription = stringResource(id = workout.TitleRes),

            )
            //descr
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))
            Text(
                text = stringResource(id = workout.DescriptionRes)
            )
            
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

