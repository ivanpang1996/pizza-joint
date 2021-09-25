import {Button, Form, Modal} from "react-bootstrap";
import React from "react";

interface Props {
    show: boolean
    handleClose: any
}

function Detail({show, handleClose}: Props) {
    return (
        <Modal size="lg" show={show} onHide={handleClose}>
            <Modal.Header>
                <Modal.Title>Topping</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <Form.Group className="mb-3" controlId="formBasicCheckbox">
                    <Form.Check type="checkbox" label="Onion"/>
                    <Form.Check type="checkbox" label="Cheese"/>
                    <Form.Check type="checkbox" label="Meat"/>
                </Form.Group>
            </Modal.Body>

            <Modal.Footer>
                <Button variant="primary">
                    Add
                </Button>
                <Button variant="secondary" onClick={handleClose}>
                    Close
                </Button>
            </Modal.Footer>
        </Modal>
    )
}

export default Detail;