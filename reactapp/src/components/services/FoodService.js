import axios from 'axios';

const EMPLOYEE_API_BASE_URL = "http://localhost:8080/api/v1/foods";

class FoodService {

    getFoods(){
        return axios.get(EMPLOYEE_API_BASE_URL);
    }

    createFood(food){
        return axios.post(EMPLOYEE_API_BASE_URL, food);
    }

    getFoodById(foodId){
        return axios.get(EMPLOYEE_API_BASE_URL + '/' + foodId);
    }

    updateFood(food, foodId){
        return axios.put(EMPLOYEE_API_BASE_URL + '/' + foodId, food);
    }

    deleteFood(foodId){
        return axios.delete(EMPLOYEE_API_BASE_URL + '/' + foodId);
    }
}

export default new FoodService()