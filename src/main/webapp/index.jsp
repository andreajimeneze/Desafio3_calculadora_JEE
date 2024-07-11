<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <meta name="keywords" content="HTML, CSS, Java, desarrollo web">
    <title>Calculadora</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link href="./assets/css/styles.css">
</head>
<body>
    <div class="container">
        <div class="w-75 mt-3 mx-5 px-5 ms-5 ps-5 m-4  bg-dark text-white">
            <h2 class="py-3">Calculadora</h2>

            <form class="form w-75 mt-3 ms-5 ps-5" method="post" action="CalculatorServlet">
                <div>
                    <input class="form-control mb-3 bg-dark text-white" type="number" name="number1" placeholder="Número 1" required>
                    <input class="form-control mb-3 bg-dark text-white" type="number" name="number2" placeholder="Número 2" required>
                    <select class="form-control mb-3" name="mathOperation">
                        <option disabled selected>Seleccione una operación aritmética</option>
                        <option value="addition">Suma</option>
                        <option value="substraction">Resta</option>
                        <option value="multiplication">Multiplicación</option>
                        <option value="divition">División</option>
                        <option value="orderBy">Ordenar números menor a mayor</option>
                        <option value="evenOdd">Par o impar</option>
                    </select>
                </div>
                <input type="submit" class="btn btn-primary mb-5 w-100">

            </form>
        </div>

        <div class="w-75 ps-5">

            <c:if test="${not empty error}">
                <div class="alert alert-danger result" role="alert">
                        <p class="result-text">${error}</p>
                </div>
            </c:if>
            <c:if test="${not empty resultText}">
            <div class="result">
                <p class="result-text"><strong>${resultText}</strong></p>
            </div>
            </c:if>
        </div>
    </div>
    <script>
        document.addEventListener("DOMContentLoaded", function() {
            let resultDiv = document.querySelector(".result");
            let resultText = document.querySelector(".result-text");

            if (resultText && resultText.innerHTML.trim() !== "") {
                resultDiv.style.display = "block";

                setTimeout(function() {
                    resultDiv.style.display = "none";
                    document.querySelector('form').reset();
                }, 3000);
            }
        });
    </script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>