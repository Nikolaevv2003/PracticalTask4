public class Doctor {
    private String fullName;
    private String speciality;
    private int serialNumber;
    private int numberOfShiftsPerMonth;
    private boolean hasCertification;

    public Doctor(String fullName, String speciality, int serialNumber, int numberOfShiftsPerMonth, boolean hasCertification) {
        this.fullName = fullName;
        this.speciality = speciality;
        if (serialNumber < 0) {
            throw new IllegalArgumentException();
        }
        this.serialNumber = serialNumber;
        if (numberOfShiftsPerMonth < 0) {
            throw new IllegalArgumentException();
        }
        this.numberOfShiftsPerMonth = numberOfShiftsPerMonth;
        this.hasCertification = hasCertification;
    }

    @Override
    public String toString() {
        return fullName + ", " + speciality + ", " + serialNumber + ", " + numberOfShiftsPerMonth + ", " + hasCertification;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        if (serialNumber < 0) {
            throw new IllegalArgumentException();
        }
        this.serialNumber = serialNumber;
    }

    public int getNumberOfShiftsPerMonth() {
        return numberOfShiftsPerMonth;
    }

    public void setNumberOfShiftsPerMonth(int numberOfShiftsPerMonth) {
        if (numberOfShiftsPerMonth < 0) {
            throw new IllegalArgumentException();
        }
        this.numberOfShiftsPerMonth = numberOfShiftsPerMonth;
    }

    public boolean isHasCertification() {
        return hasCertification;
    }

    public void setHasCertification(boolean hasCertification) {
        this.hasCertification = hasCertification;
    }
}
