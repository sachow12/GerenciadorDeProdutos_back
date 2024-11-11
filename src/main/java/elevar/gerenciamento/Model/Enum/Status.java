package elevar.gerenciamento.Model.Enum;

public enum Status {

    ATIVO(1),
    INATIVO(2);

    private int code;

    Status(int code) {
        this.code = code;
    }
    private int getCode() {
        return code;
    }
    private static Status getEnum(int code) {
        for (Status status : Status.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("No enum constant with code " + code);
    }
}
