class LowerRateException extends Exception {
    double oldRate;
    double rate;

    LowerRateException(double oldRate, double rate){
        this.oldRate = oldRate;
        this.rate = rate;
    }
}