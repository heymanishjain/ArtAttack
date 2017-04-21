<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Art Attack</title>
</head>
<body>

<div class="container">
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <!-- Wrapper for slides -->
        <div class="carousel-inner">
            <div class="item active">
                <img src="images/MonaLisa.jpg">
                <div class="carousel-caption">
                    <h3>Mona Lisa - Leonardo da Vinci</h3>
                    <p>The most famous painting in the world is the main attraction of the Louvre museum in Paris, where it is seen by six million people every year! 
                    Leonardo da Vinci painted it from the year 1503 or 1504 till shortly before he died in 1519.</p>
                </div>
            </div>
            <!-- End Item -->
            <div class="item">
                <img src="images/TheLastSupper.jpg">
                <div class="carousel-caption">
                    <h3>The Last Supper - Leonardo da Vinci</h3>
                    <p>This world famous painting is not shown in a museum, but rather covers the back wall of the dining hall at Santa Maria delle Grazie monastery in Milan, Italy. 
                       It was painted by the most famous artist of all time, Leonardo da Vinci in the late 15th-century</p>
                </div>
            </div>
            <!-- End Item -->
            <div class="item">
                <img src="images/StarryNight.jpg">
                <div class="carousel-caption">
                    <h3>Starry Night - Vincent van Gogh</h3>
                    <p>Painted by Dutch artist Vincent van Gogh in 1889, Starry Night is one of the most well known paintings in modern culture. 
                       The painting is part of the permanent collection of the Museum of Modern Art in New York.</p>
                </div>
            </div>
            <!-- End Item -->
            <div class="item">
                <img src="images/TheScream.jpg">
                <div class="carousel-caption">
                    <h3>The Scream - Edvard Munch</h3>
                    <p>The most famous piece by Edvard Munch, painted around 1893. 
                        It was painted using oil and pastel on cardboard. This frightening painting is on display at The National Gallery, Oslo, Norway.</p>
                </div>
            </div>
            <!-- End Item -->
        </div>
        <!-- End Carousel Inner -->
        <ul class="nav nav-pills nav-justified">
            <li data-target="#myCarousel" data-slide-to="0"><a href="#">About - <small>Mona Lisa</small></a></li>
            <li data-target="#myCarousel" data-slide-to="1"><a href="#">About - <small>The Last Supper</small></a></li>
            <li data-target="#myCarousel" data-slide-to="2"><a href="#">About - <small>Starry Night</small></a></li>
            <li data-target="#myCarousel" data-slide-to="3"><a href="#">About - <small>The Scream</small></a></li>
        </ul>
    </div>
<br>
<br>
</body>
</html>