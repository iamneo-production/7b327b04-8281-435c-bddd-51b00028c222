import React, { Component } from 'react'
import FoodService from '../../services/FoodService'

class AddFood extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            url: '',
            name: '',
            category: '',
            price:''
        }
        this.changeUrl=this.changeUrl.bind(this);
        this.changeName=this.changeName.bind(this);
        this.changeCategory=this.changeCategory.bind(this);
        this.changePrice=this.changePrice.bind(this);
        this.saveFood = this.saveFood.bind(this);
        this.cancel = this.cancel.bind(this);
     
     
     
     
    }
    saveFood = (e) => {
        e.preventDefault();
        let food= {url: this.state.url, name: this.state.name, category: this.state.category,price:this.state.price};
        console.log('food => ' + JSON.stringify(food));
        FoodService.createFood(food).then( (res) =>{
            this.props.history.push('/admin/foods');

            });
        
    
    }
    changeUrl= (event) => {
        this.setState({url: event.target.value});
    }
    changeName= (event) => {
        this.setState({name: event.target.value});
    }
    changeCategory=(event)=>
    {
        this.setState({category: event.target.value});

    }
    changePrice=(event)=>
    {
        this.setState({price: event.target.value});

    }
    cancel=(event)=>
    {
        this.props.history.push('/admin/foods');
    }


    render() {
        return (
            <div>
                <div>
                <br></br>
                   <div className = "container">
                 <div className = "row">
                     
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                            
                                <div className = "card-body">
                                <h2 className="text-center">Add Food</h2>
                                <br />
                        
                                    <form>
                                        <div className = "form-group">
                                            <label> Image Url </label>
                                            <input placeholder="Image Url" name="url" className="form-control" value={this.state.url} onChange={this.changeUrl}
                                              />
                                        </div>
                                        <br />
                                        <div className = "form-group">
                                            <label> Food Name </label>
                                            <input placeholder="Food Name" name="name" className="form-control"  value={this.state.name} onChange={this.changeName}
                                              />
                                        </div>
                                        <br />
                                        <div className = "form-group">
                                            <label> Food Category </label>
                                            <input placeholder="Food Category" name="category" className="form-control"   value={this.state.category} onChange={this.changeCategory}
                                              />
                                        </div>
                                        <br />
                                        <div className = "form-group">
                                            <label> Food Price </label>
                                            <input placeholder="Food Price" name="price" className="form-control"  value={this.state.price} onChange={this.changePrice}
                                              />
                                        </div>
                                        <br />
                                        <button className="btn btn-success" onClick={this.saveFood} >Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel} style={{marginLeft: "10px"}}>Cancel</button>

                                      
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
              
            </div>
        )
    }
}

export default AddFood;