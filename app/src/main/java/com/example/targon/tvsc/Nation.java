package com.example.targon.tvsc;

/**
 * Created by Targon on 06.01.2016.
 */
public class Nation {
    int id;
    //1-usa, 2-rosja, 3-ue, 4-isis, 5-bokoharam, 6-alshabad
    double money;
    double diplomacyPonit;
    int countS;
    int countA;
    int countN;
    int countD;
    double inlandPonit;
    boolean looser;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getDiplomacyPonit() {
        return diplomacyPonit;
    }

    public void setDiplomacyPonit(double diplomacyPonit) {
        this.diplomacyPonit = diplomacyPonit;
    }

    public int getCountS() {
        return countS;
    }

    public void setCountS(int countS) {
        this.countS = countS;
    }

    public int getCountA() {
        return countA;
    }

    public void setCountA(int countA) {
        this.countA = countA;
    }

    public int getCountN() {
        return countN;
    }

    public void setCountN(int countN) {
        this.countN = countN;
    }

    public double getInlandPonit() {
        return inlandPonit;
    }

    public void setInlandPonit(double inlandPonit) {
        this.inlandPonit = inlandPonit;
    }

    public boolean isLooser() {
        return looser;
    }

    public void setLooser(boolean looser) {
        this.looser = looser;
    }

    public int getCountD() {
        return countD;
    }

    public void setCountD(int countD) {
        this.countD = countD;
    }
}
