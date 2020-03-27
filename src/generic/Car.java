package generic;

//先忽略泛型的问题
public class Car implements Comparable<Car> {
    private String carNo;
    private String brand;

    public Car() {
        // TODO Auto-generated constructor stub
    }

    public Car(String carNo, String brand) {
        super();
        this.carNo = carNo;
        this.brand = brand;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((brand == null) ? 0 : brand.hashCode());
        result = prime * result + ((carNo == null) ? 0 : carNo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Car other = (Car) obj;
        if (brand == null) {
            if (other.brand != null)
                return false;
        } else if (!brand.equals(other.brand))
            return false;
        if (carNo == null) {
            if (other.carNo != null)
                return false;
        } else if (!carNo.equals(other.carNo))
            return false;
        return true;
    }

    @Override
    /*
     *定制treeSet里面的顺序
     */
    public int compareTo(Car car) {
        // TODO Auto-generated method stub
        if (car == null) {
            return -1;
        }
		/*if(!(o instanceof Car)) {
			return -1;
		}
		Car car = (Car) o;*/
        if (car.carNo.equals(this.carNo)) {
            return this.brand.compareTo(car.brand);
        } else {
            return this.carNo.compareTo(car.carNo);
        }
    }

    @Override
    public String toString() {
        return "Car [carNo=" + carNo + ", brand=" + brand + "]";
    }


}
