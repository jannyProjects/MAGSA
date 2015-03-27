# Oddelenie
entity Oddelenie {
    nazov : string required, length 5 30
    kod : string required, length 1 4
    uroven : real
}

# Zamestnanec
entity Zamestnanec {
    meno : string required, length 2 30
    priezvisko : string required, length 2 30
    vek : integer
}

reference Zamestnanec Oddelenie
