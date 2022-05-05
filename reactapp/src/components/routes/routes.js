import DisplayFood from "../components/admin/DisplayFood";
import AddFood from "../components/admin/AddFood"
import Profile from "../components/admin/Profile";
import UpdateFood from "../components/admin/UpdateFood";
import ThemeList from "../components/admin/ThemeList";
import AddTheme from "../components/admin/AddTheme";
import UpdateTheme from "../components/admin/UpdateTheme";
import Dashboard from "../components/admin/Dashboard";
import Theme from "../components/user/Theme";

const routes=[

    {path:'/admin',exact:true,name:'Admin'},
    {path:'/user',exact:true,name:'User'},
    {path:'/user/theme',exact:true,name:'Theme Display',component:Theme},
    {path:'/admin/foods',exact:true,name:'Food Display',component:DisplayFood},
    {path:'/admin/addFood',exact:true,name:'Add Food',component:AddFood},
    {path:'/admin/updateFood/:id',exact:true,name:'Update Food',component:UpdateFood},
    {path:'/admin/themeList',exact:true,name:'List Of Themes',component:ThemeList},
    {path:'/admin/addTheme',exact:true,name:'Add Theme',component:AddTheme},
    {path:'/admin/updateTheme/:id',exact:true,name:'Update Theme',component:UpdateTheme},
    {path:'/admin/Dashboard',exact:true,name:'Dashboard',component:Dashboard},


    

];

export default routes;