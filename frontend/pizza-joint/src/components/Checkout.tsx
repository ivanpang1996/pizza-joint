import React, {useState} from "react";

export interface OrderItem {
    pizzaName: string
    price: number
    quantity: number
}

interface Props {
    items : Array<OrderItem>
}


function CheckOutForm({items}: Props) {
    return (
        <>
            <h4 className="d-flex justify-content-between align-items-center mb-3"><span
                className="text-muted">Your bill</span></h4>

            <ul className="list-group mb-3">
                {items.map(item => (
                    <li className="list-group-item d-flex justify-content-between lh-condensed">
                        <div>
                            <h6 className="my-0">{item.pizzaName} x {item.quantity}</h6>
                            <span className="text-muted">${item.price * item.quantity}</span>
                        </div>
                    </li>
                ))
                }
            </ul>
        </>
    )
}

export default CheckOutForm;