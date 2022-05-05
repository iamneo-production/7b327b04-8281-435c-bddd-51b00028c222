import axios from 'axios';

const Theme_API_BASE_URL = "http://localhost:8080/api/v1/theme";

class ThemeService {

    getTheme(){
        return axios.get(Theme_API_BASE_URL);
    }

    createTheme(theme){
        return axios.post(Theme_API_BASE_URL,theme);
    }

    getThemeById(themeId){
        return axios.get(Theme_API_BASE_URL + '/' + themeId);
    }

    updateTheme(theme, themeId){
        return axios.put(Theme_API_BASE_URL + '/' + themeId, theme);
    }

    deleteTheme(themeId){
        return axios.delete(Theme_API_BASE_URL + '/' + themeId);
    }
}

export default new ThemeService()