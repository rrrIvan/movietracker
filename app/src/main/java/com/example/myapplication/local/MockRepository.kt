package com.example.myapplication.local

import com.example.myapplication.local.model.Actor
import com.example.myapplication.local.model.Movie

class MockRepository {
    fun getMovies() = listOf(
        Movie(
            id = 0,
            title = "0 Avengers: End Game",
            poster = "https://s3.amazonaws.com/prod.assets.thebanner/styles/article-large/s3/article/large/MM-037%20Avengers_%20Endgame.jpg",
            ageLimit = 16,
            tags = listOf("Action", "Adventure", "Fantasy"),
            rating = 2,
            reviews = 119,
            storyline = "After the devastating events of Avengers: Infinity War, the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos\\' actions and restore balance to the universe.",
            duration = 100,
            isLiked = true,
            cast = listOf(
                Actor(0,"Alicia Vikander", "https://image.ibb.co/nKNBrd/Alicia_Vikander.jpg"),
                Actor(1,"Amanda Seyfried", "https://image.ibb.co/j142xJ/Amanda_Seyfried.jpg"),
                Actor(2,"Anne Hathaway", "https://image.ibb.co/euy6Py/Anne_Hathaway.jpg"),
                Actor(3,"Emma Stone", "https://image.ibb.co/dJY6Py/Emma_Stone.jpg"),
                Actor(4,"Keira Knightley", "https://image.ibb.co/cxX0jy/Keira_Knightley.jpg"),
            )
        ),
        Movie(
            id = 1,
            title = "1 Tenet",
            poster = "https://www.joblo.com/assets/images/joblo/posters/2020/08/tenetpostersfinal3.jpg",
            ageLimit = 10,
            tags = listOf("Action", "Thriller", "Sci-Fi"),
            rating = 4,
            reviews = 64,
            storyline = "Empty",
            duration = 134,
            isLiked = false,
            cast = listOf(
                Actor(0,"George Clooney", "https://image.ibb.co/ce1t4y/George_Clooney.jpg"),
                Actor(1,"Lucy Liu", "https://image.ibb.co/dWurrd/Lucy_Liu.jpg"),
                Actor(2,"Matthew McConaughey", "https://image.ibb.co/e3JHWd/Matthew_Mc_Conaughey.jpg"),
                Actor(3,"Morgan Freeman", "https://image.ibb.co/h9GhxJ/Morgan_Freeman.jpg"),
                Actor(5,"Ryan Gosling", "https://image.ibb.co/buLLjy/Ryan_Gosling.jpg"),
                Actor(6,"Will Smith", "https://image.ibb.co/gxoUcJ/Will_Smith.jpg"),
                Actor(7,"Robert de Niro", "https://image.ibb.co/e6T6Py/Robert_de_Niro.jpg"),
                Actor(8,"Zoe Saldana", "https://image.ibb.co/i9WRPy/Zoe_Saldana.jpg")

            )
        ),
        Movie(
            id = 2,
            title = "2 Avengers: End Game",
            poster = "https://s3.amazonaws.com/prod.assets.thebanner/styles/article-large/s3/article/large/MM-037%20Avengers_%20Endgame.jpg",
            ageLimit = 16,
            tags = listOf("Action", "Adventure", "Fantasy"),
            rating = 2,
            reviews = 119,
            storyline = "After the devastating events of Avengers: Infinity War, the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos\\' actions and restore balance to the universe.",
            duration = 100,
            isLiked = true,
            cast = listOf(
                Actor(0,"Alicia Vikander", "https://image.ibb.co/nKNBrd/Alicia_Vikander.jpg"),
                Actor(1,"Amanda Seyfried", "https://image.ibb.co/j142xJ/Amanda_Seyfried.jpg"),
                Actor(2,"Anne Hathaway", "https://image.ibb.co/euy6Py/Anne_Hathaway.jpg"),
                Actor(3,"Emma Stone", "https://image.ibb.co/dJY6Py/Emma_Stone.jpg"),
                Actor(4,"Keira Knightley", "https://image.ibb.co/cxX0jy/Keira_Knightley.jpg"),
            )
        ),
        Movie(
            id = 3,
            title = "3 Tenet",
            poster = "https://www.joblo.com/assets/images/joblo/posters/2020/08/tenetpostersfinal3.jpg",
            ageLimit = 10,
            tags = listOf("Action", "Thriller", "Sci-Fi"),
            rating = 4,
            reviews = 64,
            storyline = "Empty",
            duration = 134,
            isLiked = false,
            cast = listOf(
                Actor(0,"George Clooney", "https://image.ibb.co/ce1t4y/George_Clooney.jpg"),
                Actor(1,"Lucy Liu", "https://image.ibb.co/dWurrd/Lucy_Liu.jpg"),
                Actor(2,"Matthew McConaughey", "https://image.ibb.co/e3JHWd/Matthew_Mc_Conaughey.jpg"),
                Actor(3,"Morgan Freeman", "https://image.ibb.co/h9GhxJ/Morgan_Freeman.jpg"),
                Actor(5,"Ryan Gosling", "https://image.ibb.co/buLLjy/Ryan_Gosling.jpg"),
                Actor(6,"Will Smith", "https://image.ibb.co/gxoUcJ/Will_Smith.jpg"),
                Actor(7,"Robert de Niro", "https://image.ibb.co/e6T6Py/Robert_de_Niro.jpg"),
                Actor(8,"Zoe Saldana", "https://image.ibb.co/i9WRPy/Zoe_Saldana.jpg")

            )
        ),
        Movie(
            id = 4,
            title = "4 Avengers: End Game",
            poster = "https://s3.amazonaws.com/prod.assets.thebanner/styles/article-large/s3/article/large/MM-037%20Avengers_%20Endgame.jpg",
            ageLimit = 16,
            tags = listOf("Action", "Adventure", "Fantasy"),
            rating = 2,
            reviews = 119,
            storyline = "After the devastating events of Avengers: Infinity War, the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos\\' actions and restore balance to the universe.",
            duration = 100,
            isLiked = true,
            cast = listOf(
                Actor(0,"Alicia Vikander", "https://image.ibb.co/nKNBrd/Alicia_Vikander.jpg"),
                Actor(1,"Amanda Seyfried", "https://image.ibb.co/j142xJ/Amanda_Seyfried.jpg"),
                Actor(2,"Anne Hathaway", "https://image.ibb.co/euy6Py/Anne_Hathaway.jpg"),
                Actor(3,"Emma Stone", "https://image.ibb.co/dJY6Py/Emma_Stone.jpg"),
                Actor(4,"Keira Knightley", "https://image.ibb.co/cxX0jy/Keira_Knightley.jpg"),
            )
        ),
        Movie(
            id = 5,
            title = "5 Tenet",
            poster = "https://www.joblo.com/assets/images/joblo/posters/2020/08/tenetpostersfinal3.jpg",
            ageLimit = 10,
            tags = listOf("Action", "Thriller", "Sci-Fi"),
            rating = 4,
            reviews = 64,
            storyline = "Empty",
            duration = 134,
            isLiked = false,
            cast = listOf(
                Actor(0,"George Clooney", "https://image.ibb.co/ce1t4y/George_Clooney.jpg"),
                Actor(1,"Lucy Liu", "https://image.ibb.co/dWurrd/Lucy_Liu.jpg"),
                Actor(2,"Matthew McConaughey", "https://image.ibb.co/e3JHWd/Matthew_Mc_Conaughey.jpg"),
                Actor(3,"Morgan Freeman", "https://image.ibb.co/h9GhxJ/Morgan_Freeman.jpg"),
                Actor(5,"Ryan Gosling", "https://image.ibb.co/buLLjy/Ryan_Gosling.jpg"),
                Actor(6,"Will Smith", "https://image.ibb.co/gxoUcJ/Will_Smith.jpg"),
                Actor(7,"Robert de Niro", "https://image.ibb.co/e6T6Py/Robert_de_Niro.jpg"),
                Actor(8,"Zoe Saldana", "https://image.ibb.co/i9WRPy/Zoe_Saldana.jpg")

            )
        ),
        Movie(
            id = 6,
            title = "6 Avengers: End Game",
            poster = "https://s3.amazonaws.com/prod.assets.thebanner/styles/article-large/s3/article/large/MM-037%20Avengers_%20Endgame.jpg",
            ageLimit = 16,
            tags = listOf("Action", "Adventure", "Fantasy"),
            rating = 2,
            reviews = 119,
            storyline = "After the devastating events of Avengers: Infinity War, the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos\\' actions and restore balance to the universe.",
            duration = 100,
            isLiked = true,
            cast = listOf(
                Actor(0,"Alicia Vikander", "https://image.ibb.co/nKNBrd/Alicia_Vikander.jpg"),
                Actor(1,"Amanda Seyfried", "https://image.ibb.co/j142xJ/Amanda_Seyfried.jpg"),
                Actor(2,"Anne Hathaway", "https://image.ibb.co/euy6Py/Anne_Hathaway.jpg"),
                Actor(3,"Emma Stone", "https://image.ibb.co/dJY6Py/Emma_Stone.jpg"),
                Actor(4,"Keira Knightley", "https://image.ibb.co/cxX0jy/Keira_Knightley.jpg"),
            )
        ),
        Movie(
            id = 7,
            title = "7 Tenet",
            poster = "https://www.joblo.com/assets/images/joblo/posters/2020/08/tenetpostersfinal3.jpg",
            ageLimit = 10,
            tags = listOf("Action", "Thriller", "Sci-Fi"),
            rating = 4,
            reviews = 64,
            storyline = "Empty",
            duration = 134,
            isLiked = false,
            cast = listOf(
                Actor(0,"George Clooney", "https://image.ibb.co/ce1t4y/George_Clooney.jpg"),
                Actor(1,"Lucy Liu", "https://image.ibb.co/dWurrd/Lucy_Liu.jpg"),
                Actor(2,"Matthew McConaughey", "https://image.ibb.co/e3JHWd/Matthew_Mc_Conaughey.jpg"),
                Actor(3,"Morgan Freeman", "https://image.ibb.co/h9GhxJ/Morgan_Freeman.jpg"),
                Actor(5,"Ryan Gosling", "https://image.ibb.co/buLLjy/Ryan_Gosling.jpg"),
                Actor(6,"Will Smith", "https://image.ibb.co/gxoUcJ/Will_Smith.jpg"),
                Actor(7,"Robert de Niro", "https://image.ibb.co/e6T6Py/Robert_de_Niro.jpg"),
                Actor(8,"Zoe Saldana", "https://image.ibb.co/i9WRPy/Zoe_Saldana.jpg")

            )
        ),
        Movie(
            id = 8,
            title = "8 Avengers: End Game",
            poster = "https://s3.amazonaws.com/prod.assets.thebanner/styles/article-large/s3/article/large/MM-037%20Avengers_%20Endgame.jpg",
            ageLimit = 16,
            tags = listOf("Action", "Adventure", "Fantasy"),
            rating = 2,
            reviews = 119,
            storyline = "After the devastating events of Avengers: Infinity War, the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos\\' actions and restore balance to the universe.",
            duration = 100,
            isLiked = true,
            cast = listOf(
                Actor(0,"Alicia Vikander", "https://image.ibb.co/nKNBrd/Alicia_Vikander.jpg"),
                Actor(1,"Amanda Seyfried", "https://image.ibb.co/j142xJ/Amanda_Seyfried.jpg"),
                Actor(2,"Anne Hathaway", "https://image.ibb.co/euy6Py/Anne_Hathaway.jpg"),
                Actor(3,"Emma Stone", "https://image.ibb.co/dJY6Py/Emma_Stone.jpg"),
                Actor(4,"Keira Knightley", "https://image.ibb.co/cxX0jy/Keira_Knightley.jpg"),
            )
        ),
        Movie(
            id = 9,
            title = "9 Tenet",
            poster = "https://www.joblo.com/assets/images/joblo/posters/2020/08/tenetpostersfinal3.jpg",
            ageLimit = 10,
            tags = listOf("Action", "Thriller", "Sci-Fi"),
            rating = 4,
            reviews = 64,
            storyline = "Empty",
            duration = 134,
            isLiked = false,
            cast = listOf(
                Actor(0,"George Clooney", "https://image.ibb.co/ce1t4y/George_Clooney.jpg"),
                Actor(1,"Lucy Liu", "https://image.ibb.co/dWurrd/Lucy_Liu.jpg"),
                Actor(2,"Matthew McConaughey", "https://image.ibb.co/e3JHWd/Matthew_Mc_Conaughey.jpg"),
                Actor(3,"Morgan Freeman", "https://image.ibb.co/h9GhxJ/Morgan_Freeman.jpg"),
                Actor(5,"Ryan Gosling", "https://image.ibb.co/buLLjy/Ryan_Gosling.jpg"),
                Actor(6,"Will Smith", "https://image.ibb.co/gxoUcJ/Will_Smith.jpg"),
                Actor(7,"Robert de Niro", "https://image.ibb.co/e6T6Py/Robert_de_Niro.jpg"),
                Actor(8,"Zoe Saldana", "https://image.ibb.co/i9WRPy/Zoe_Saldana.jpg")

            )
        ),
        Movie(
            id = 10,
            title = "10 Avengers: End Game",
            poster = "https://s3.amazonaws.com/prod.assets.thebanner/styles/article-large/s3/article/large/MM-037%20Avengers_%20Endgame.jpg",
            ageLimit = 16,
            tags = listOf("Action", "Adventure", "Fantasy"),
            rating = 2,
            reviews = 119,
            storyline = "After the devastating events of Avengers: Infinity War, the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos\\' actions and restore balance to the universe.",
            duration = 100,
            isLiked = true,
            cast = listOf(
                Actor(0,"Alicia Vikander", "https://image.ibb.co/nKNBrd/Alicia_Vikander.jpg"),
                Actor(1,"Amanda Seyfried", "https://image.ibb.co/j142xJ/Amanda_Seyfried.jpg"),
                Actor(2,"Anne Hathaway", "https://image.ibb.co/euy6Py/Anne_Hathaway.jpg"),
                Actor(3,"Emma Stone", "https://image.ibb.co/dJY6Py/Emma_Stone.jpg"),
                Actor(4,"Keira Knightley", "https://image.ibb.co/cxX0jy/Keira_Knightley.jpg"),
            )
        ),
        Movie(
            id = 11,
            title = "11 Tenet",
            poster = "https://www.joblo.com/assets/images/joblo/posters/2020/08/tenetpostersfinal3.jpg",
            ageLimit = 10,
            tags = listOf("Action", "Thriller", "Sci-Fi"),
            rating = 4,
            reviews = 64,
            storyline = "Empty",
            duration = 134,
            isLiked = false,
            cast = listOf(
                Actor(0,"George Clooney", "https://image.ibb.co/ce1t4y/George_Clooney.jpg"),
                Actor(1,"Lucy Liu", "https://image.ibb.co/dWurrd/Lucy_Liu.jpg"),
                Actor(2,"Matthew McConaughey", "https://image.ibb.co/e3JHWd/Matthew_Mc_Conaughey.jpg"),
                Actor(3,"Morgan Freeman", "https://image.ibb.co/h9GhxJ/Morgan_Freeman.jpg"),
                Actor(5,"Ryan Gosling", "https://image.ibb.co/buLLjy/Ryan_Gosling.jpg"),
                Actor(6,"Will Smith", "https://image.ibb.co/gxoUcJ/Will_Smith.jpg"),
                Actor(7,"Robert de Niro", "https://image.ibb.co/e6T6Py/Robert_de_Niro.jpg"),
                Actor(8,"Zoe Saldana", "https://image.ibb.co/i9WRPy/Zoe_Saldana.jpg")

            )
        ),
    )
}