import {Button, Card, Col} from "react-bootstrap";
import React from "react";
import {Pizza} from "../App";

interface Props {
    pizza: Pizza;
    setShow: any;
}


function PizzaCard({pizza, setShow}: Props) {
    return (
        <Col>
            <Card>
                <Card.Img variant="top"
                          src="https://images.squarespace-cdn.com/content/v1/5bc638369b8fe864b188a448/1585095534330-M4VQKXQ1CYALK8NAQ0FI/Pepperoni.jpg?format=1500w"/>
                <Card.Body>
                    <Card.Subtitle className="mb-2 text-muted">{pizza.name}</Card.Subtitle>
                    <Card.Text>
                        ${pizza.price}
                    </Card.Text>
                    <Button variant="primary" onClick={() => {
                        setShow(true);
                    }}>Choose</Button>
                </Card.Body>
            </Card>
        </Col>
    )
}

export default PizzaCard;