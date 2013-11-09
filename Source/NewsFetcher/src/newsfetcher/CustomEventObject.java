/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newsfetcher;

/**
 * Đối tượng tham số cho sự kiện CustomEventListener
 * @author Duong Dieu Phap
 */
public class CustomEventObject {

    /**
     * Giá trị nhỏ nhất
     */
    public int _min = 0;
    /**
     * Giá trị hiện tại
     */
    public int _value = 0;
    /**
     * Giá trị lớn nhất
     */
    public int _max = 1;
    /**
     * Biến dự trữ, muốn lưu cái gì thì lưu
     */
    public Object _message = null;
    
    /**
     * Lưu thông báo lỗi nếu có
     */
    public String _errorMessage = "";
    
    /**
     * Khởi tạo mới đối tượng
     */
    public CustomEventObject() {
    }
    
    /**
     * Khởi tạo mới đối tượng có tham số
     * @param min Giá trị nhỏ nhất
     * @param max Giá trị lớn nhất
     */
    public CustomEventObject(int min, int max) {
        this._min = min;
        this._max = max;
    }
}
