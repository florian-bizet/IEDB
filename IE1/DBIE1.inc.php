<?php

require 'PlayerIE1.inc.php';

class DBIE1 {
	private static $singleton = null; 
	private $connexion=null; 
	
	/* Constructor */
	private function __construct() {
		$connStr = 'pgsql:host=localhost port=5432 dbname=mitsu'; 
		try {
			//Connecting to DB
			$this->connexion = new PDO($connStr, 'mitsu', 'amogus'); 
			$this->connexion->setAttribute(PDO::ATTR_CASE, PDO::CASE_LOWER); 
			$this->connexion->setAttribute(PDO::ATTR_ERRMODE , PDO::ERRMODE_EXCEPTION); 
		} catch (PDOException $e) {
	  		echo "probleme de connexion :".$e->getMessage();  
			return null; 
		}
	}

	  //Singleton Pattern
	public static function getInstance() {
		self::$singleton = (self::$singleton == null ? new DBIE1() : self::$singleton);

		//Connection error
		if (self::$singleton->connexion == null) {
			self::$singleton=null;
		}

		return self::$singleton;
	}

	public function close() {
		$this->connexion = null;
	}

	//General purpose query executing method
	private function execQuery($query,$parameterArray,$returnClass) {

		$stmt = $this->connexion->prepare($query);
		$stmt->setFetchMode(PDO::FETCH_CLASS|PDO::FETCH_PROPS_LATE, $returnClass); 

		if ($parameterArray != null) {
			$stmt->execute($parameterArray);
		}
		else {
		 	$stmt->execute();
		}
		 
		$tab = array();
		$record = $stmt->fetch();
		while ($record != false) {
			$tab[] = $record;
			$record = $stmt->fetch();
		}
		
		return $tab;    
	}

	public function getPlayerList() {
		return $this->execQuery("SELECT * FROM Player WHERE japanesedesc != '' ORDER BY shortromanname",null,'Player');
	}



}

?>
