<?php

function connect(){
    $PARAM_HOST = "localhost";
    $PARAM_PORT = "3306";
    $PARAM_BD = "mora";
    $PARAM_USER = "root";
    $PARAM_PASS = "";
    $connexion = new PDO('mysql:host='.$PARAM_HOST. ';port='.$PARAM_PORT.'dbname='.$PARAM_BD, $PARAM_USER, $PARAM_PASS);
    return $connexion;
}