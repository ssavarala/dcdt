package gov.hhs.onc.dcdt.mail;

public enum BindingType {
    NONE, ANY, ADDRESS, DOMAIN;

    public boolean isBound() {
        return (this.isAddressBound() || this.isDomainBound());
    }

    public boolean isAddressBound() {
        return (this == ADDRESS);
    }

    public boolean isDomainBound() {
        return (this == DOMAIN);
    }
}
