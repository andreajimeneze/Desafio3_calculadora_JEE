package cl.praxis.calculadora_jee.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.DecimalFormat;

@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int number1 = Integer.parseInt(req.getParameter("number1"));
        int number2 = Integer.parseInt(req.getParameter("number2"));
        String mathOperation = req.getParameter("mathOperation");
        String resultText = "";


        try{
            switch(mathOperation) {
                case "addition":
                    int addition = number1 + number2;
                    resultText = "La suma de los números " + number1 + " y " + number2 + " es " + addition;
                    break;
                case "substraction":
                    resultText = "La resta de los números " + number1 + " y " + number2 + " es " + (number1 - number2);
                    break;
                case "multiplication":
                    resultText = "La multiplicación de los números " + number1 + " y " + number2 + " es " + number1 * number2;
                    break;
                case "divition":

                        if(number2 == 0) {
                            throw new ArithmeticException("No se puede dividir por cero");
                        } else {
                            resultText = "La división de " + number1 + " y " + number2 + " es " + ((double) number1 / number2);
                        }
                        break;
                case "orderBy":
                    int numMax = Math.max(number1, number2);
                    int numMin = Math.min(number1, number2);

                    if(numMax != numMin) {
                        resultText = "El número " + numMax + " es mayor que " + numMin;
                    } else {
                        resultText = "El número " + numMax + " es igual a " + numMin;
                    }
                    break;
                case "evenOdd":
                    //int[] numbers  = {number1, number2};
                    String result = "";
                    DecimalFormat df = new DecimalFormat("##.##");
                    if(number1 %2 == 0 & number2 %2 == 0) {
                        resultText = "Los números " + number1 + " y " + number2 + " son pares";
                    } else if(number1 %2 != 0 & number2 %2 != 0) {
                        resultText = "Los números " + number1 + " y " + number2 + " son impares";
                    } else if(number1 %2 == 0 && number2 %2 != 0) {
                        resultText = "El número " + number1 + " es par y el número " + number2 + " es impar";
                    } else {
                        resultText = "El número " + number1 + " es impar y el número " + number2 + " es par";
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Opción no válida");
            }
        } catch (ArithmeticException e) {
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("index.jsp").forward(req, res);
            return;
        } catch (Exception e) {
            req.setAttribute("error", "Ocurrió un error inesperado: " + e.getMessage());
            req.getRequestDispatcher("index.jsp").forward(req, res);
            return;
        }

        req.setAttribute("resultText", resultText);
        req.setAttribute("number1", number1);
        req.setAttribute("number2", number2);

        req.getRequestDispatcher("index.jsp").forward(req, res);
    }

}

