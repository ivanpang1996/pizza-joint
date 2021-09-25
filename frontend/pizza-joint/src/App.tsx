import React, {useState} from 'react';
import {Row} from "react-bootstrap";
import PizzaCard from "./components/PizzaCard";
import CheckOutForm, {OrderItem} from "./components/Checkout";
import Detail from "./components/Detail";

export interface Pizza {
    name: string
    price: number
}

function App() {
    const [show, setShow] = useState(false);
    const handleClose = () => setShow(false);
    const handleAdd = (chosenPizza: Pizza) => {
        setOrderItems([...orderItems, {pizzaName: chosenPizza.name, price: chosenPizza.price, quantity: 1}])
    }
    const [currentPizza, setCurrentPizza] = useState<Pizza>({
        name: "pizza1",
        price: 10
    });
    const [orderItems, setOrderItems] = useState<Array<OrderItem>>([]);
    const [pizzas, setPizzas] = useState<Array<Pizza>>([
        {
            name: "pizza1",
            price: 10
        },
        {
            name: "pizza2",
            price: 20
        },
        {
            name: "pizza3",
            price: 30
        }]);


    return (
        <div className="py-5 text-center">
            <h3 className="text-muted">Pizza Joint</h3>
            <div className="row">
                <div className="col-md-8 order-md-1">
                    <Row xs={1} md={4}>
                        {
                            pizzas.map(pizza => (
                                <PizzaCard pizza={pizza} setShow={setShow} setCurrentPizza={setCurrentPizza}/>
                            ))
                        }

                    </Row>
                </div>

                <div className="col-md-4 order-md-2 mb-4">
                    <CheckOutForm items={orderItems}/>
                </div>
            </div>
            <Detail pizza={currentPizza} handleClose={handleClose} handleAdd={handleAdd} show={show}/>
        </div>
    );
}

export default App;
