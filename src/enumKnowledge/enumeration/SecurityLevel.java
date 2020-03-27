package enumKnowledge.enumeration;

public enum SecurityLevel {
    PROVINCE(0),
    CITY(2),
    DISTRICK(3);

    private int securityLevel;

    private SecurityLevel(int securityLevel) {
        this.securityLevel = securityLevel;
    }

    public int getSecurityLevel() {
        return securityLevel;
    }
}
