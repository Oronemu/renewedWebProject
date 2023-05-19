import { WS_URL } from '../../config';

let notificationService;
let isOn = false;

export const connectNotification = (callback) => {
  if (isOn) return;
  notificationService = new WebSocket(WS_URL);
  notificationService.onmessage = (event) => {
    callback(event.data);
  };
  isOn = true;
};

export const closeNotification = () => {
  if (!isOn) return;
  notificationService.close();
  isOn = false;
};
