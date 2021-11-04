package com.example.sehealthy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DetailDietActivity : AppCompatActivity() {
    private val dietPlan = listOf(
        "Only eat fruits on this day. You can eat any food except banana\nRecommended Fruits :",
        "Only eat vegetables on this day. You can eat any vegetables you like\nRecommended Vegetables :",
        "You can eat any vegetables and fruits you like on the third day. However do not have banana and potatoes\nList :",
        "On day 4 you can eat banana and glasses of milk\nList :",
        "You can eat cooked rice and tomato soup\nList :",
        "On day 6 you can eat meat and vegetables you wish\nList :",
        "On the final day, you can eat cooked rice, fruits, and vegetables as much as you like\nList :")

    private val recommendedMeals = listOf(
        listOf(
            mapOf("name" to "mango", "image" to R.drawable.mango),
            mapOf("name" to "watermelon", "image" to R.drawable.watermelon),
            mapOf("name" to "cantaloupe", "image" to R.drawable.cantaloupe),
            mapOf("name" to "8 to 12 glass of water", "image" to R.drawable.water),
        ),
        listOf(
            mapOf("name" to "Large boiled potato (cooked or raw without oil)", "image" to R.drawable.potato),
            mapOf("name" to "8 to 12 glass of water", "image" to R.drawable.water),
        ),
        listOf(
            mapOf("name" to "Eat all fruits", "image" to R.drawable.fruit),
            mapOf("name" to "Uncooked or cooked vegetables without oil", "image" to R.drawable.salad),
            mapOf("name" to "8 to 12 glass of water", "image" to R.drawable.water),
        ),
        listOf(
            mapOf("name" to "Eat 8 to 12 bananas", "image" to R.drawable.banana),
            mapOf("name" to "Drink 3 glasses of milk", "image" to R.drawable.milk),
            mapOf("name" to "8 to 12 glass of water", "image" to R.drawable.water),
        ),
        listOf(
            mapOf("name" to "Tomato soup or any vegetables soup", "image" to R.drawable.soup),
            mapOf("name" to "one cup of cooked rice", "image" to R.drawable.rice),
            mapOf("name" to "8 to 12 glass of water", "image" to R.drawable.water),
        ),
        listOf(
            mapOf("name" to "500gr meat", "image" to R.drawable.meat),
            mapOf("name" to "Any vegetables except potato", "image" to R.drawable.vegetable),
            mapOf("name" to "8 to 12 glass of water", "image" to R.drawable.water),
        ),
        listOf(
            mapOf("name" to "1 cooked rice", "image" to R.drawable.rice),
            mapOf("name" to "Any vegetables and fruit", "image" to R.drawable.vegetable),
            mapOf("name" to "8 to 12 glass of water", "image" to R.drawable.water),
        ),
    )

    private val recommendedWorkoutSteps = arrayListOf(
        """
            60 sec run in place
            5 sit up - 4 repetitions 
            6 leg lifts - 4 repetitions 
        """.trimIndent(),
        """
            5 plie squats - 2 repetitions 
            5 leg swings - 2 repetitions 
            5 side lunges - 4 repetitions
        """.trimIndent(),
        """
            5 lateral lunges - 4 repetitions 
            5 squat jump - 4 repetitions 
            6 ankle reaches - 2 repetitions 
        """.trimIndent(),
        """
            5 push up - 4 repetitions 
            5 leg swings - 2 repetitions 
            3 roll-up - 2 repetitions
        """.trimIndent(),
        """
            5 X-Up - 4 repetitions 
            6 ankle reaches - 2 repetitions 
            60 sec run in place
        """.trimIndent(),
        """
            5 squat jump - 4 repetitions
            6 leg lifts - 4 repetitions 
            5 roll-up - 2 repetitions
        """.trimIndent(),
        """
            5 X-Up - 4 repetitions
            5 push up - 4 repetitions 
            5 side lunges - 4 repetitions
        """.trimIndent()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_diet)

        val toolbar = findViewById<Toolbar>(R.id.toolbar_detail)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = null

        val pos = intent.getIntExtra("pos", 0)
        val dayTv = findViewById<TextView>(R.id.tv_day)
        val descTv = findViewById<TextView>(R.id.tv_desc)
        val dietRv = findViewById<RecyclerView>(R.id.rv_diet_plan)
        val workoutTv = findViewById<TextView>(R.id.tv_workout)

        dayTv.text = getString(R.string.day, (pos + 1).toString())
        descTv.text = dietPlan[pos]
        workoutTv.text = "${getString(R.string.recommended_workout)}\n${recommendedWorkoutSteps[pos]}"

        val adapter = DetailDietAdapter(recommendedMeals[pos])
        dietRv.adapter = adapter
        dietRv.layoutManager = LinearLayoutManager(this)

    }
}