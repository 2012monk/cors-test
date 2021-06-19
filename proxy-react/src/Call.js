import React from 'react';
import axios from 'axios';
import { useState } from 'react';
const CallButton = ({url, name}) => {
    const [data, setData] = useState('');
    const call = () => axios.get(url);
    const click = async () => {
        const res = await call();
        setData(res.data);
    }
    return (
        <div>
            <button onClick={click}>
                {name ? name : "button"}
            </button>
            <div className="res">
                {data}
            </div>
        </div>
    )
}

export default CallButton;