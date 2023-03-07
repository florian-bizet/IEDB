<?php 
    function htmlHeader() {
        return "<!DOCTYPE html>
        <html lang=\"en\">
        <head>
            <meta charset=\"UTF-8\">
            <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">
            <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">
            <title>IEDB : Inazuma Eleven Database</title>
            <link rel=\"stylesheet\" type=\"text/css\" href=\"../style.css\"/>
        </head>
        <body>
            <header>
                <h1>IEDB</h1>
                <h2>Inazuma Eleven Database</h2>
            </header>";
    }

    function htmlFooter() {
        return "<footer>
                    <p>2023 - florian-bizet</p>
                </footer>
            </body>
        </html>";
    }
?>