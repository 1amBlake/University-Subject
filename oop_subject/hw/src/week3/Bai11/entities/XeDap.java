package week3.Bai11.entities;

public class XeDap extends Xe {

	public XeDap(Integer maThue, Double donGia) {
		super(maThue, donGia);
	}

	@Override
	protected double getVATrate() {
		return 0;
	}

	@Override
	protected double getThueTruocBarate() {
		return 0;
	}

}
