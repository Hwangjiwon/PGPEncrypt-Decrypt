package PGPEncrypt_Decrypt_Sign_Verify;

public class Main {
	
	//서명 복호화 -- 송신자의 공개키
	private static final String SENDER_DE_INPUT = "/home/lfvn/0608/EncryptTest.txt.asc";
	private static final String SENDER_DE_OUTPUT = "/home/lfvn/0608/SignDecryptTest2.txt";
	private static final String SENDER_DE_KEY_FILE = "/home/lfvn/0608/vietnam0608_pub.key"; //vietnam 공개키
	
	//메시지 복호화 -- 수신자의 개인키
	private static final String PASSPHRASE = "jiwon0608";
	private static final String DE_INPUT = "/home/lfvn/0608/SignDecryptTest2.txt";
	private static final String DE_OUTPUT = "/home/lfvn/0608/tmpDecTest.txt";
	private static final String DE_KEY_FILE = "/home/lfvn/0608/jiwon0608_sec.key"; //jiwon 개인키
	
	private static final String E_INPUT = "src/test/x.txt";
	private static final String E_OUTPUT = "src/test/x.pgp";
	private static final String E_KEY_FILE = "src/test/pubring.pkr"; //베트남 공개키
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Decrypt Sign 0608");
		testSignDecrypt();
		System.out.println("Decrypt Message");
		testDecrypt();
	}

	public static void testDecrypt() throws Exception {
		PGPFileProcessor p = new PGPFileProcessor();
		p.setInputFileName(DE_INPUT);
		p.setOutputFileName(DE_OUTPUT);
		p.setPassphrase(PASSPHRASE);
		p.setSecretKeyFileName(DE_KEY_FILE);
		System.out.println(p.decrypt());
	}
	
	public static void testSignDecrypt() throws Exception {
		PGPFileProcessor p = new PGPFileProcessor();
		p.setInputFileName(SENDER_DE_INPUT);
		p.setOutputFileName(SENDER_DE_OUTPUT);
		p.setPassphrase(PASSPHRASE);
		p.setSecretKeyFileName(SENDER_DE_KEY_FILE);
		System.out.println(p.signDecrypt());
	}

	public static void testEncrypt() throws Exception {
		PGPFileProcessor p = new PGPFileProcessor();
		p.setInputFileName(E_INPUT);
		p.setOutputFileName(E_OUTPUT);
		p.setPassphrase(PASSPHRASE);
		p.setPublicKeyFileName(E_KEY_FILE);
		System.out.println(p.encrypt());
	}
}
