CREATE TABLE Player (
    playerID INT PRIMARY KEY,
    kanjiName TEXT CHARACTER SET utf8 COLLATE utf8_unicode_ci,
    shortKanaName TEXT CHARACTER SET utf8 COLLATE utf8_unicode_ci,
    longKanaName TEXT CHARACTER SET utf8 COLLATE utf8_unicode_ci,
    shortRomanName TEXT CHARACTER SET utf8 COLLATE utf8_unicode_ci,
    longRomanName TEXT CHARACTER SET utf8 COLLATE utf8_unicode_ci,
    japaneseDesc TEXT CHARACTER SET utf8 COLLATE utf8_unicode_ci,
    pGP INT,
    pTP INT,
    pKick INT,
    pBody INT,
    pControl INT,
    pGuard INT,
    pSpeed INT,
    pStamina INT,
    pGuts INT
);