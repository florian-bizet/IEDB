<?php 
    include("htmlstruct.inc.php");
    include("DBIE1.inc.php");
    include_once("PlayerIE1.inc.php");

    ini_set('display_errors', 1);
    ini_set('display_startup_errors', 1);
    error_reporting(E_ALL);

    echo(htmlHeader() );
    echo(pageContent());
    echo(htmlFooter() );

    function pageContent() {
        $htmlCode = "<section id=\"playerList\">";

        $connexion = DBIE1::getInstance();

        $index = 0;

        foreach ($connexion->getPlayerList() as $player) {
            $htmlCode = $htmlCode . "<div class='" . ($index%2 == 0 ? "evenID" : "oddID") . "'>";
            $htmlCode = $htmlCode . "<a href='viewPlayer.php?id=". $player->getID() ."'>" . $player->getShortRomanName() . "</a>";
            $htmlCode = $htmlCode . "</div>";
            $index++;
        }

        $htmlCode = $htmlCode . "</section>";

        return $htmlCode;
    }
?>