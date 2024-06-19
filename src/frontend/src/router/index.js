import { createRouter, createWebHistory } from 'vue-router';
import HelloWorld from "@/components/HelloWorld.vue";
import AllEvents from "@/components/AllEvents.vue";
import VoteEvent from "@/components/VoteEvent.vue";
import AddNewEvent from "@/components/AddNewEvent.vue";
import DeleteEvent from "@/components/DeleteEvent.vue";
import UpdateEvent from "@/components/UpdateEvent.vue";


const routes = [
    {
        path: '/HelloWorld',
        name: 'HelloWorld',
        component: HelloWorld
    },
    {
        path: '/AllEvents',
        name: 'AllEvents',
        component: AllEvents
    },
    {
        path: '/VoteEvent/:voteId',
        name: 'VoteEvent',
        component: VoteEvent
    },
    {
        path: '/AddNewEvent',
        name: 'AddNewEvent',
        component: AddNewEvent
    },
    {
        path: '/DeleteEvent',
        name: 'DeleteEvent',
        component: DeleteEvent
    },
    {
        path: '/UpdateEvent/:voteId',
        name: 'UpdateEvent',
        component: UpdateEvent
    },

];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;