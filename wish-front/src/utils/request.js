import axios from 'axios'
const request = axios.create({
    baseURL: 'http://111.229.123.137:8080',
    timeout: 6000
})
export default request
