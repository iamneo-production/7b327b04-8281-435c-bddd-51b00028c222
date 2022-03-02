import React, { Component } from 'react'
import FoodService from '../../services/FoodService'

class DisplayFood extends Component {
    constructor(props) {
        super(props)

        this.state = {
                foods: []
        }
        this.addFood = this.addFood.bind(this);
        this.editFood = this.editFood.bind(this);
        this.deleteFood = this.deleteFood.bind(this);
      
      
    }
    componentDidMount(){
       FoodService.getFoods().then((res) => {
            this.setState({ foods: res.data});
        });
    }
    deleteFood(id)
    {
        FoodService.deleteFood(id).then( res => {
            this.setState({foods: this.state.foods.filter(food => food.id !== id)});
        });

    }
    addFood(){
        this.props.history.push('/admin/addFood');
    }
    editFood(id){
        this.props.history.push(`/admin/updateFood/${id}`);
    }
  render() {
    return (
        <div className="container">
        <h2 className="text-center">List of Food</h2>
        <div className = "row">
           <button className="btn btn-primary" onClick={this.addFood} style={{width:"100px"}}> Add Food</button>
        </div>
        <br></br>
        <div className = "row">
               <table className = "table table-hover table-dark">

                   <thead>
                       <tr>
                           <th>Food Image</th>
                           <th>Food Name</th>
                           <th> Food Category</th>
                           <th> Food Price</th>
                           <th> Actions</th>
                       </tr>
                   </thead>
                   <tbody>
                       {
                           this.state.foods.map(
                               food => 
                               <tr key = {food.id}>
                                    <td> <img src={food.url} style={{height:"90px",width:"190px"}}></img> </td>   
                                    <td> {food.name}</td>
                                    <td> {food.category}</td>
                                    <td>{food.price}</td>
                                    <td>
                                    <button  onClick={ () => this.editFood(food.id)} className="btn btn-info">Update </button>
                                                 <button  onClick={ () => this.deleteFood(food.id)} style={{marginLeft: "10px"}}  className="btn btn-danger">Delete </button>
                                                 
                                    </td>
                               </tr>
                           )
                       }
                   </tbody>
               </table>

        </div>

   </div>
    )
  }
}
export default DisplayFood;
