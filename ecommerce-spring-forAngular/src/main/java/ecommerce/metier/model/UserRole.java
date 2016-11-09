package ecommerce.metier.model;

public enum UserRole {
	ROLE_CLIENT("CLIENT"), ROLE_ADMIN_CAT("ADMIN_CAT"), ROLE_ADMIN_PROD("ADMIN_PROD");

	private final String label;

	private UserRole(String label) {
		this.label = label;

	}

	public String getLabel() {
		return label;
	}
}
