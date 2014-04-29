package gov.hhs.onc.dcdt.crypto.keys;

import gov.hhs.onc.dcdt.crypto.CryptographyAlgorithmIdentifier;
import gov.hhs.onc.dcdt.dns.DnsKeyAlgorithmType;
import gov.hhs.onc.dcdt.net.mime.CoreContentTypes;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.springframework.util.MimeType;

public enum KeyAlgorithm implements CryptographyAlgorithmIdentifier {
    RSA("RSA", PKCSObjectIdentifiers.rsaEncryption, "X.509", "PKCS#8", 512, new MimeType(CoreContentTypes.APP_TYPE, "pkcs8"), DnsKeyAlgorithmType.RSASHA1);

    private final String id;
    private final ASN1ObjectIdentifier oid;
    private final AlgorithmIdentifier algId;
    private final String publicFormat;
    private final String privateFormat;
    private final int keySizeMin;
    private final MimeType contentType;
    private final DnsKeyAlgorithmType dnsAlgType;

    private KeyAlgorithm(String id, ASN1ObjectIdentifier oid, String publicFormat, String privateFormat, int keySizeMin, MimeType contentType,
        DnsKeyAlgorithmType dnsAlgType) {
        this.id = id;
        this.oid = oid;
        this.algId = new AlgorithmIdentifier(this.oid);
        this.publicFormat = publicFormat;
        this.privateFormat = privateFormat;
        this.keySizeMin = keySizeMin;
        this.contentType = contentType;
        this.dnsAlgType = dnsAlgType;
    }

    @Override
    public AlgorithmIdentifier getAlgorithmId() {
        return this.algId;
    }

    public MimeType getContentType() {
        return this.contentType;
    }

    public DnsKeyAlgorithmType getDnsAlgorithmType() {
        return this.dnsAlgType;
    }

    public String getFormat(KeyType keyType) {
        return (keyType == KeyType.PUBLIC) ? this.getPublicFormat() : this.getPrivateFormat();
    }

    @Override
    public String getId() {
        return this.id;
    }

    public int getKeySizeMin() {
        return this.keySizeMin;
    }

    @Override
    public ASN1ObjectIdentifier getOid() {
        return this.oid;
    }

    public String getPublicFormat() {
        return this.publicFormat;
    }

    public String getPrivateFormat() {
        return this.privateFormat;
    }
}