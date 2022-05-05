import React, { Component } from 'react'
import FoodService from '../../services/FoodService'

class Dashboard extends Component {
    constructor(props) {
        super(props)

        this.state = {
                foods: []
        }
      
      
    }
    componentDidMount(){
      FoodService.getFoods().then((res) => {
           this.setState({ foods: res.data});
       });
   }
    
 
   
   
  render() {
    return (
        <div className="container-lg">
        <h2 className="text-center">List of Food</h2>
        <div className='row'>

          {
            this.state.foods.map(
              food=>
              <div className='col'>
              <div className="card" style={{width: "18rem"}}>
            
                   
              <div class="card-body" key={food.id}>
              <img class="card-img-top" src={food.url} style={{height:"90px",width:"190px"}} alt="Card image cap"/>
              <h6 class="card-title"><p>Name:&nbsp;&nbsp;{food.name}</p></h6>
              <h6 class="card-title"><p>Food Category:&nbsp;&nbsp;{food.category}</p></h6>
              <h6 class="card-title"><p>Food Price:&nbsp;&nbsp;{food.price}</p></h6>
              </div>
             
      
      </div>
      <br />
      </div>

            )
          }


        
        </div>
       
        
        
        
       


</div>
        
    );
  }
}
export default Dashboard;
