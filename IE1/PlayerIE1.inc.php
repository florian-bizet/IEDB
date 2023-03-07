<?php 

class Player {
    private $playerid;

    private $kanjiname;
    private $longkananame;
    private $shortkananame;
    private $longromanname;
    private $shortromanname;

    private $japanesedesc;
    
    private $pgp;
    private $ptp;
    private $pkick;
    private $pbody;
    private $pcontrol;
    private $pguard;
    private $pspeed;
    private $pstamina;
    private $pguts;

    

    /**
     * @param mixed $id
     * @param mixed $kanjiname
     * @param mixed $longkananame
     * @param mixed $shortkananame
     * @param mixed $longromanname
     * @param mixed $shortromanname
     * @param mixed $japanesedesc
     * @param mixed $pgp
     * @param mixed $ptp
     * @param mixed $pkick
     * @param mixed $pbody
     * @param mixed $pcontrol
     * @param mixed $pguard
     * @param mixed $pspeed
     * @param mixed $pstamina
     * @param mixed $pguts
     */
    public function __construct($playerid=-1, $kanjiname="", $longkananame="", $shortkananame="", $longromanname="", $shortromanname="", $japanesedesc="", $pgp=-1, $ptp=-1, $pkick=-1, $pbody=-1, $pcontrol=-1, $pguard=-1, $pspeed=-1, $pstamina=-1, $pguts=-1) {
    	$this->playerid = $playerid;
    	$this->kanjiname = $kanjiname;
    	$this->longkananame = $longkananame;
    	$this->shortkananame = $shortkananame;
    	$this->longromanname = $longromanname;
    	$this->shortromanname = $shortromanname;
    	$this->japanesedesc = $japanesedesc;
    	$this->pgp = $pgp;
    	$this->ptp = $ptp;
    	$this->pkick = $pkick;
    	$this->pbody = $pbody;
    	$this->pcontrol = $pcontrol;
    	$this->pguard = $pguard;
    	$this->pspeed = $pspeed;
    	$this->pstamina = $pstamina;
    	$this->pguts = $pguts;
    }

    public function getID() {return $this->playerid;}
    public function getKanjiName() {return $this->kanjiname;}
    public function getLongKanaName() {return $this->longkananame;}
    public function getShortKanaName() {return $this->shortkananame;}
    public function getLongRomanName() {return $this->longromanname;}
    public function getShortRomanName() {return $this->shortromanname;}
    public function getJapaneseDescription() {return $this->japanesedesc;}
    public function getGP() {return $this->pgp;}
    public function getTP() {return $this->ptp;}
    public function getKick() {return $this->pkick;}
    public function getBody() {return $this->pbody;}
    public function getControl() {return $this->pcontrol;}
    public function getGuard() {return $this->pguard;}
    public function getSpeed() {return $this->pspeed;}
    public function getStamina() {return $this->pstamina;}
    public function getGuts() {return $this->pguts;}



}

?>