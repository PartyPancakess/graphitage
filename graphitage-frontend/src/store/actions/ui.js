import * as actionTypes from './actionTypes';



export const openContextMenu = (sourceNode) => {
    return {
        type: actionTypes.OPEN_CONTEXT_MENU,
        sourceNode: sourceNode
    }
}

export const closeContextMenu = () => {
    return {
        type: actionTypes.CLOSE_CONTEXT_MENU,
    }
}