import { User } from './user.model';

export interface Event {
    eventId: number;
    title: string;
    description: string;
    eventDate: string;
    capacity: number;
    price: number;
    category: string;
    location: string;
    imageBase64: string;
    organizer: User;
}
