<template>
    <div>
        <v-banner>Game Code: {{game.code}}</v-banner>
    </div>
</template>

<script>
import { mapState } from "vuex";

export default {
    data() {
        return {};
    },

    computed: {
        ...mapState({
            game: state => state.game
        })
    }
};
</script>