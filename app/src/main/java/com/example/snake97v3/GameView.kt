package com.example.snake97v3

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Point
import android.os.Handler
import android.os.Looper
import android.view.MotionEvent
import android.view.View
import java.util.*
import kotlin.random.Random

class GameView(context: Context) : View(context) {

    private val boardSize = 20
    private val cellSize: Int
        get() = width / boardSize
    private var handler = Handler(Looper.getMainLooper())
    private var runnable = Runnable { updateGame() }
    private var gameRunning = true
    private var score = 0

    private val boardColor = Paint().apply {
        color = 0xFF00FF00.toInt() // Green color
    }
    private val snakeColor = Paint().apply {
        color = 0xFFFF0000.toInt() // Red color
    }
    private val foodColor = Paint().apply {
        color = 0xFF0000FF.toInt() // Blue color
    }
    private val scorePaint = Paint().apply {
        color = 0xFFFFFFFF.toInt() // White color
        textSize = 50f
    }

    private var snake: LinkedList<Point> = LinkedList()
    private var food: Point? = null
    private var direction = Direction.RIGHT

    init {
        resetGame()
    }

    fun resume() {
        handler.post(runnable) // Start the game
    }

    fun pause() {
        handler.removeCallbacks(runnable) // Stop the game
    }

    private fun resetGame() {
        snake.clear()
        snake.add(Point(boardSize / 2, boardSize / 2))
        generateFood()
        direction = Direction.RIGHT
        gameRunning = true
        score = 0
    }

    private fun generateFood() {
        var foodX: Int
        var foodY: Int
        do {
            foodX = Random.nextInt(boardSize)
            foodY = Random.nextInt(boardSize)
        } while (snake.contains(Point(foodX, foodY)))
        food = Point(foodX, foodY)
    }

    private fun updateGame() {
        if (!gameRunning) {
            return
        }

        // Update snake
        val head = snake.peekFirst()
        val newPoint = Point(head)
        when (direction) {
            Direction.UP -> newPoint.y--
            Direction.DOWN -> newPoint.y++
            Direction.LEFT -> newPoint.x--
            Direction.RIGHT -> newPoint.x++
        }

        // Check for collisions
        if (newPoint.x < 0 || newPoint.y < 0 || newPoint.x >= boardSize || newPoint.y >= boardSize ||
            snake.contains(newPoint)
        ) {
            gameRunning = false
            invalidate() // Redraw the view now
            return
        }

        // Add new head to the snake
        snake.push(newPoint)

        // Check for food
        if (newPoint == food) {
            generateFood()
            score++ // Increase the score when the snake eats food
        } else {
            // Remove tail if didn't eat
            snake.removeLast()
        }

        // Redraw the view and schedule the next update
        invalidate()
        handler.postDelayed(runnable, 200) // 200 ms delay = 5 updates/second
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Draw game board
        for (i in 0 until boardSize) {
            for (j in 0 until boardSize) {
                val left = i * cellSize
                val top = j * cellSize
                val right = left + cellSize
                val bottom = top + cellSize
                canvas.drawRect(left.toFloat(), top.toFloat(), right.toFloat(), bottom.toFloat(), boardColor)
            }
        }

        // Draw snake
        for (point in snake) {
            val left = point.x * cellSize
            val top = point.y * cellSize
            val right = left + cellSize
            val bottom = top + cellSize
            canvas.drawRect(left.toFloat(), top.toFloat(), right.toFloat(), bottom.toFloat(), snakeColor)
        }

        // Draw food
        food?.let {
            val left = it.x * cellSize
            val top = it.y * cellSize
            val right = left + cellSize
            val bottom = top + cellSize
            canvas.drawRect(left.toFloat(), top.toFloat(), right.toFloat(), bottom.toFloat(), foodColor)
        }

        // Draw score
        canvas.drawText("Score: $score", 10f, 60f, scorePaint)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (!gameRunning) {
            resetGame()
            handler.post(runnable) // Start the game
            return true
        }

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                val x = event.x.toInt() / cellSize
                val y = event.y.toInt() / cellSize
                val head = snake.peekFirst()
                if (x < head.x) {
                    direction = Direction.LEFT
                } else if (x > head.x) {
                    direction = Direction.RIGHT
                } else if (y < head.y) {
                    direction = Direction.UP
                } else if (y > head.y) {
                    direction = Direction.DOWN
                }
            }
        }

        return true
    }

    private enum class Direction {
        UP, DOWN, LEFT, RIGHT
    }
}
